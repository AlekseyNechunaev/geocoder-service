package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Envelope {

    @JsonProperty("lowerCorner")
    private String mLowerCorner;
    @JsonProperty("upperCorner")
    private String mUpperCorner;

    public String getLowerCorner() {
        return mLowerCorner;
    }

    public void setLowerCorner(String lowerCorner) {
        mLowerCorner = lowerCorner;
    }

    public String getUpperCorner() {
        return mUpperCorner;
    }

    public void setUpperCorner(String upperCorner) {
        mUpperCorner = upperCorner;
    }

}
