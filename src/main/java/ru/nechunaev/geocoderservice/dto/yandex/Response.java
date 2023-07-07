package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("GeoObjectCollection")
    private GeoObjectCollection mGeoObjectCollection;

    public GeoObjectCollection getGeoObjectCollection() {
        return mGeoObjectCollection;
    }

    public void setGeoObjectCollection(GeoObjectCollection geoObjectCollection) {
        mGeoObjectCollection = geoObjectCollection;
    }

}
