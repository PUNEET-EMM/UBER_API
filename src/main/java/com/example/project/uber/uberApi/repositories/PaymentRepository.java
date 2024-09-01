package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Payment;
import com.example.project.uber.uberApi.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);

}
