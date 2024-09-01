package com.example.project.uber.uberApi.services;

import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.Wallet;
import com.example.project.uber.uberApi.entities.enums.TransactionMethod;

public interface WalletService {
    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride,
                            TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride,
                                 TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
