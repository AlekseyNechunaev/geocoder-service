package ru.nechunaev.geocoderservice.common.mapper;

import org.springframework.stereotype.Component;
import ru.nechunaev.geocoderservice.dto.CoordinatesDto;

import java.util.Arrays;
import java.util.List;

@Component
public class CoordinatesMapper {

    public String convertCoordinatesToString(CoordinatesDto dto) {
        return dto.getLatitude() + "," + dto.getLongitude();
    }

    public CoordinatesDto convertListCoordinatesToDto(String[] coordinates) {
        final CoordinatesDto dto = new CoordinatesDto();
        List<Double> preparedCoords = Arrays.stream(coordinates)
                .map(Double::parseDouble)
                .toList();
        dto.setLatitude(getGeographicalCoordinatesByType(GeographicalCoordinates.LATITUDE, preparedCoords));
        dto.setLongitude(getGeographicalCoordinatesByType(GeographicalCoordinates.LONGITUDE, preparedCoords));
        return dto;
    }

    private Double getGeographicalCoordinatesByType(GeographicalCoordinates type, List<Double> coordinates) {
        switch (type) {
            case LATITUDE -> {
                return coordinates.get(0);
            }
            case LONGITUDE -> {
                return coordinates.get(1);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private enum GeographicalCoordinates {
        LATITUDE,
        LONGITUDE
    }
}
