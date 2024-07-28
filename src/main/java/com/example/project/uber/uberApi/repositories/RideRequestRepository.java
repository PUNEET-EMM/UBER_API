package com.example.project.uber.uberApi.repositories;


import com.example.project.uber.uberApi.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRequestRepository extends JpaRepository<RideRequest,Long> {
}
