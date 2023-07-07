package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalCode {

    @JsonProperty("PostalCodeNumber")
    private String mPostalCodeNumber;

    public String getPostalCodeNumber() {
        return mPostalCodeNumber;
    }

    public void setPostalCodeNumber(String postalCodeNumber) {
        mPostalCodeNumber = postalCodeNumber;
    }

}
