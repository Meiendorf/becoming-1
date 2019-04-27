package com.meiendorf.notificationservice.repository;

import com.meiendorf.notificationservice.exceptions.NotFoundException;
import com.meiendorf.notificationservice.models.EmailRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class EmailRepository {
    private Map<Integer, EmailRequest> requests = new ConcurrentHashMap<>();

    public EmailRequest addRequest(EmailRequest request){
        request.setId();
        requests.put(request.getId(), request);
        return request;
    }

    public EmailRequest getById(int id){
        EmailRequest request = requests.get(id);
        if(request == null){
            throw new NotFoundException();
        }
        return request;
    }
}
