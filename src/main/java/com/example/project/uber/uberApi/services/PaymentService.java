package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.entities.Payment;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.enums.PaymentStatus;

public interface PaymentService {
    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
