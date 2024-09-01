package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.User;
import com.example.project.uber.uberApi.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Object> findByUser(User user);
}
