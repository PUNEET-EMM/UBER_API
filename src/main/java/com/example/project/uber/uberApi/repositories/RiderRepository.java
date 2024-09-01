package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
