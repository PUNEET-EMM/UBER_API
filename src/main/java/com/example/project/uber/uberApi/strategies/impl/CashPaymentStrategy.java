package com.example.project.uber.uberApi.strategies.impl;

import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.Payment;
import com.example.project.uber.uberApi.entities.enums.PaymentStatus;
import com.example.project.uber.uberApi.entities.enums.TransactionMethod;
import com.example.project.uber.uberApi.repositories.PaymentRepository;
import com.example.project.uber.uberApi.services.WalletService;
import com.example.project.uber.uberApi.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;
//
//    @Override
//    public void processPayment(Payment payment) {
//        Driver driver = payment.getRide().getDriver();
//
//        Double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;
//
//        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null, payment.getRide(), TransactionMethod.RIDE);
//        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
//        paymentRepository.save(payment);

        @Override
        public void processPayment(Payment payment) {
            Driver driver = payment.getRide().getDriver();

            double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

            walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                    payment.getRide(), TransactionMethod.RIDE);

            payment.setPaymentStatus(PaymentStatus.CONFIRMED);
            paymentRepository.save(payment);
        }


}



