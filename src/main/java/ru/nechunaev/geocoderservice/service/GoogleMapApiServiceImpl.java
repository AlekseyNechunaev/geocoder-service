package ru.nechunaev.geocoderservice.service;

import com.google.maps.GeoApiContext;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapApiServiceImpl implements GoogleMapApiService {

    private final GeoApiContext context;

    @Autowired
    public GoogleMapApiServiceImpl(GeoApiContext context) {
        this.context = context;
    }

    @Override
    public GeocodingResult[] convertAddressToCoordinates(String address) {
        return new GeocodingResult[0];
    }

    @Override
    public GeocodingResult[] convertCoordinatesToAddress(double latitude, double longitude) {
        return new GeocodingResult[0];
    }
}
