package ru.nechunaev.geocoderservice.dto;

import jakarta.validation.constraints.NotNull;
import ru.nechunaev.geocoderservice.validation.annotation.Latitude;
import ru.nechunaev.geocoderservice.validation.annotation.Longitude;

public class CoordinatesDto {
    @NotNull
    @Latitude
    private Double latitude;

    @NotNull
    @Longitude
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
