package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeatureMember {

    @JsonProperty("GeoObject")
    private GeoObject mGeoObject;

    public GeoObject getGeoObject() {
        return mGeoObject;
    }

    public void setGeoObject(GeoObject geoObject) {
        mGeoObject = geoObject;
    }

}
