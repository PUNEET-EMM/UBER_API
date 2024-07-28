package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.services.DistanceService;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public Double calculateDistance(Point src, Point dest) {
        return 0.0;
    }
}
