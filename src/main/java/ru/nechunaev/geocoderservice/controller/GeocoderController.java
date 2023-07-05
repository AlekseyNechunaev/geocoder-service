package ru.nechunaev.geocoderservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nechunaev.geocoderservice.common.constant.ApiPath;
import ru.nechunaev.geocoderservice.dto.AddressDto;

@RestController
@RequestMapping(ApiPath.API_PATH)
public class GeocoderController {

    @PostMapping(ApiPath.FIND_COORDINATES)
    public String findCoordinates() {
        return null;
    }

    @PostMapping(ApiPath.FIND_ADDRESS)
    public AddressDto findAddress() {
        return null;
    }
}
