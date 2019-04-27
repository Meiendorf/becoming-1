package com.meiendorf.notificationservice.services;

import com.meiendorf.notificationservice.exceptions.BadRequestException;
import com.meiendorf.notificationservice.exceptions.ValidationError;
import com.meiendorf.notificationservice.helper.StringHelper;
import com.meiendorf.notificationservice.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailValidatorService {

    @Autowired
    StringHelper strHelper;

    public void validate(EmailRequest request) {
        List<ValidationError> errors = new ArrayList<>();

        if(strHelper.isNullOrEmpty(request.getTo())){
            errors.add(new ValidationError("to", "can't be null or empty"));
        }
        if(strHelper.isNullOrEmpty(request.getSubject())){
            errors.add(new ValidationError("subject", "can't be null or empty"));
        }
        if(strHelper.isNullOrEmpty(request.getText())){
            errors.add(new ValidationError("text", "can't be null or empty"));
        }

        if(errors.size() > 0){
            throw new BadRequestException(errors);
        }
    }
}
