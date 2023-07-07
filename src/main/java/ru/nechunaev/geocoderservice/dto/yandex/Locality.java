package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locality {

    @JsonProperty("LocalityName")
    private String mLocalityName;
    @JsonProperty("Thoroughfare")
    private Thoroughfare mThoroughfare;

    public String getLocalityName() {
        return mLocalityName;
    }

    public void setLocalityName(String localityName) {
        mLocalityName = localityName;
    }

    public Thoroughfare getThoroughfare() {
        return mThoroughfare;
    }

    public void setThoroughfare(Thoroughfare thoroughfare) {
        mThoroughfare = thoroughfare;
    }

}
