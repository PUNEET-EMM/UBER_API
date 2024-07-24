package com.example.project.uber.uberApi.entities;

import jakarta.persistence.*;
import org.springframework.data.geo.Point;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    private Double rating;
    private Boolean available;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    Point currentLocation;


}
