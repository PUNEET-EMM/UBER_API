package com.example.project.uber.uberApi.strategies;

import com.example.project.uber.uberApi.entities.enums.PaymentMethod;
import com.example.project.uber.uberApi.strategies.impl.CashPaymentStrategy;
import com.example.project.uber.uberApi.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {
    private final CashPaymentStrategy cashPaymentStrategy;
    private final WalletPaymentStrategy walletPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }

}
