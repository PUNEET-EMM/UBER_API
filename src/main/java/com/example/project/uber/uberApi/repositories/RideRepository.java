package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {

    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
