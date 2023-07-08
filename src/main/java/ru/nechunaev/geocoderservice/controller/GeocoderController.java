package ru.nechunaev.geocoderservice.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nechunaev.geocoderservice.common.constant.ApiPath;
import ru.nechunaev.geocoderservice.dto.AddressDto;
import ru.nechunaev.geocoderservice.dto.CoordinatesDto;
import ru.nechunaev.geocoderservice.service.GeocoderService;

@RestController
@RequestMapping(ApiPath.API_PATH)
public class GeocoderController {

    private final GeocoderService geocoderService;

    @Autowired
    public GeocoderController(GeocoderService geocoderService) {
        this.geocoderService = geocoderService;
    }

    @PostMapping(ApiPath.FIND_COORDINATES)
    public CoordinatesDto findCoordinates(@Valid @RequestBody AddressDto dto) {
        return geocoderService.getCoordinatesByAddress(dto);
    }

    @PostMapping(ApiPath.FIND_ADDRESS)
    public AddressDto findAddress(@Valid @RequestBody CoordinatesDto dto) {
        return geocoderService.getAddressByCoordinates(dto);
    }
}
