package com.example.project.uber.uberApi.strategies;

import com.example.project.uber.uberApi.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
