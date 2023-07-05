package ru.nechunaev.geocoderservice.service;

import com.google.maps.model.GeocodingResult;

public interface GoogleMapApiService {

    GeocodingResult[] convertAddressToCoordinates(String address);

    GeocodingResult[] convertCoordinatesToAddress(double latitude, double longitude);

}
