package com.meiendorf.notificationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    private List<ValidationError> errors;

    public BadRequestException(List<ValidationError> errors){
        this.errors = errors;
    }

    public BadRequestException(String field, String message){
        this.errors = new ArrayList<>();
        errors.add(new ValidationError(field, message));
    }

    public List<ValidationError> getErrors() {
        return errors;
    }

    @Override
    public String getMessage() {
        return Arrays.toString(errors.toArray());
    }
}
