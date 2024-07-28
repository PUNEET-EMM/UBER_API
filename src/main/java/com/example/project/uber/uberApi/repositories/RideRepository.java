package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RideRepository extends JpaRepository<Ride,Long> {
}
