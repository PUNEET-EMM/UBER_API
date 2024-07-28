package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
