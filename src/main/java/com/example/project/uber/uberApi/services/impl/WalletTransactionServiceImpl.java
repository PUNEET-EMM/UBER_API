package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.entities.WalletTransaction;
import com.example.project.uber.uberApi.repositories.WalletTransactionRepository;
import com.example.project.uber.uberApi.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {
    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }
}
