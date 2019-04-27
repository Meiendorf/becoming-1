package com.meiendorf.notificationservice.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {
    public boolean isNullOrEmpty(String str){
        return str == null || str.replace(" ", "") == "";
    }
}
