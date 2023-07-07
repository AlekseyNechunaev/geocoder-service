package ru.nechunaev.geocoderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nechunaev.geocoderservice.dto.AddressDto;
import ru.nechunaev.geocoderservice.dto.CoordinatesDto;

@Service
public class GeocoderServiceImpl implements GeocoderService {
    private static final Logger log = LoggerFactory.getLogger(GeocoderServiceImpl.class);
    private final YandexMapApiService yandexMapApiService;

    @Autowired
    public GeocoderServiceImpl(YandexMapApiService yandexMapApiService) {
        this.yandexMapApiService = yandexMapApiService;
    }

    @Override
    public AddressDto getAddressByCoordinates(CoordinatesDto coordinatesDto) {
        return null;
    }

    @Override
    public CoordinatesDto getCoordinatesByAddress(AddressDto addressDto) {
        return null;
    }
}
