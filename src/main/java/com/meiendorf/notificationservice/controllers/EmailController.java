package com.meiendorf.notificationservice.controllers;

import com.meiendorf.notificationservice.configuration.ConfigProperties;
import com.meiendorf.notificationservice.exceptions.BadRequestException;
import com.meiendorf.notificationservice.exceptions.NotFoundException;
import com.meiendorf.notificationservice.models.EmailRequest;
import com.meiendorf.notificationservice.repository.EmailRepository;
import com.meiendorf.notificationservice.services.EmailService;
import com.meiendorf.notificationservice.services.EmailValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("email")
@RestController
public class EmailController {

    @Autowired
    private EmailService service;
    @Autowired
    private EmailRepository repository;
    @Autowired
    private EmailValidatorService validatorService;

    @PostMapping
    public String sendEmail(@RequestBody EmailRequest request) throws MessagingException {
        validatorService.validate(request);
        try {
            service.sendEmail(request);
        }catch (MessagingException e)
        {
            throw new BadRequestException("messagingException", e.getMessage());
        }
        int id = repository.addRequest(request).getId();
        return "Success, message was sent with id : "+id;
    }

    @GetMapping("{id}")
    public EmailRequest getById(@PathVariable int id){
        return repository.getById(id);
    }
}
