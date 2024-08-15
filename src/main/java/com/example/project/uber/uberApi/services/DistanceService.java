package com.example.project.uber.uberApi.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    Double calculateDistance(Point src, Point dest);
}
