package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.Wallet;
import com.example.project.uber.uberApi.entities.WalletTransaction;
import com.example.project.uber.uberApi.entities.enums.TransactionMethod;
import com.example.project.uber.uberApi.entities.enums.TransactionType;
import com.example.project.uber.uberApi.exceptions.ResourceNotFoundException;
import com.example.project.uber.uberApi.repositories.WalletRepository;
import com.example.project.uber.uberApi.services.WalletService;
import com.example.project.uber.uberApi.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;

    @Override
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() + amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);

        return walletRepository.save(wallet);


    }

    @Override
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() - amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);


        return walletRepository.save(wallet);

    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId).orElseThrow(() -> new ResourceNotFoundException("Wallet not found with id: " + walletId));
    }


    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(0.0);
        return walletRepository.save(wallet);
    }


    @Override
    public Wallet findByUser(User user) {

        return (Wallet) walletRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found for user with id: " + user.getId()));
    }

}
