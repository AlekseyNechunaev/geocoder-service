package ru.nechunaev.geocoderservice.dto;

import jakarta.validation.constraints.NotNull;
import ru.nechunaev.geocoderservice.validation.annotation.Latitude;
import ru.nechunaev.geocoderservice.validation.annotation.Longitude;

public class CoordinatesDto {
    @NotNull
    @Latitude(message = "the value must be in the range >= -90 to <=90")
    private Double latitude;

    @NotNull
    @Longitude(message = "the value must be in the range >= -180 to <= 180")
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
