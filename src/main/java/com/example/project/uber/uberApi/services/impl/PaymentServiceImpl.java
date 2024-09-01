package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.entities.Payment;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.enums.PaymentStatus;
import com.example.project.uber.uberApi.exceptions.ResourceNotFoundException;
import com.example.project.uber.uberApi.repositories.PaymentRepository;
import com.example.project.uber.uberApi.services.PaymentService;
import com.example.project.uber.uberApi.strategies.PaymentStrategyManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentStrategyManager paymentStrategyManager;

    @Override
    public void processPayment(Ride ride) {
        Payment payment = paymentRepository.findByRide(ride)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found for ride with id: " + ride.getId()));
        paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);

    }

    @Override
    public Payment createNewPayment(Ride ride) {
        Payment payment = Payment.builder()
                .ride(ride)
                .paymentMethod(ride.getPaymentMethod())
                .paymentStatus(PaymentStatus.PENDING)
                .amount(ride.getFare())
                .build();
        return paymentRepository.save(payment);

    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus status) {
        payment.setPaymentStatus(status);
        paymentRepository.save(payment);

    }
}
