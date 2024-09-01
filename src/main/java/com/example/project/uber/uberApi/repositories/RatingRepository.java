package com.example.project.uber.uberApi.repositories;

import com.example.project.uber.uberApi.entities.Driver;
import com.example.project.uber.uberApi.entities.Rating;
import com.example.project.uber.uberApi.entities.Ride;
import com.example.project.uber.uberApi.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRider(Rider rider);

    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
