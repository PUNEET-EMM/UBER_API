package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {

}
