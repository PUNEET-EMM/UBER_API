package com.example.project.uber.uberApi.services.impl;

import com.example.project.uber.uberApi.services.DistanceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceServiceOSRMImpl implements DistanceService {
    private  static  final   String OSRM_API_BASE_URL = "https://router.project-osrm.org/route/v1/driving/";

    @Override
    public Double calculateDistance(Point src, Point dest) {
        try {
            String uri = String.format("%f,%f;%f,%f",
                    src.getX(), src.getY(),
                    dest.getX(), dest.getY());
            OSRMResponseDto responseDto = RestClient
                    .builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            assert responseDto != null;
            return  responseDto.getRoutes().getFirst().getDistance()/1000;

        } catch (Exception e) {
            throw new RuntimeException("Error getting data from OSRM "+e.getMessage());
        }

    }
}

@Data
 class  OSRMResponseDto{
    private List<OSRMRoute> routes;

}
@Data
class  OSRMRoute{
    private  Double distance;
}