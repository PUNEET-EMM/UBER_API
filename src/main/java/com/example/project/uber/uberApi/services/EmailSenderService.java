package com.example.project.uber.uberApi.services;

public interface EmailSenderService {
    void sendEmail(String toEmail, String subject, String body);

    void sendEmail(String toEmail[], String subject, String body);
}
