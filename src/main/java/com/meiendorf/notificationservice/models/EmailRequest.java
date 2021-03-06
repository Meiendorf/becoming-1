package com.meiendorf.notificationservice.models;

public class EmailRequest {

    public static int count = 0;

    private int id;
    private String to;
    private String text;
    private String subject;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = count;
        count++;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
