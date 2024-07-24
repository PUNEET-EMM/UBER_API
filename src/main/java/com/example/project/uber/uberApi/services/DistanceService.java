package com.example.project.uber.uberApi.services;

import org.springframework.data.geo.Point;

public interface DistanceService {
    Double calculateDistance(Point src,Point dest);
}
