package ru.nechunaev.geocoderservice.service;

import ru.nechunaev.geocoderservice.dto.AddressDto;
import ru.nechunaev.geocoderservice.dto.CoordinatesDto;

public interface GeocoderService {

    AddressDto getAddressByCoordinates(CoordinatesDto coordinatesDto);

    CoordinatesDto getCoordinatesByAddress(AddressDto addressDto);
}
