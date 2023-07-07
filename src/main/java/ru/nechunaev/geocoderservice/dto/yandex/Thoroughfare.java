package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thoroughfare {

    @JsonProperty("Premise")
    private Premise mPremise;
    @JsonProperty("ThoroughfareName")
    private String mThoroughfareName;

    public Premise getPremise() {
        return mPremise;
    }

    public void setPremise(Premise premise) {
        mPremise = premise;
    }

    public String getThoroughfareName() {
        return mThoroughfareName;
    }

    public void setThoroughfareName(String thoroughfareName) {
        mThoroughfareName = thoroughfareName;
    }

}
