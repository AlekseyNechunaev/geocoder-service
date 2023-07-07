package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDetails {

    @JsonProperty("Country")
    private Country mCountry;

    public Country getCountry() {
        return mCountry;
    }

    public void setCountry(Country country) {
        mCountry = country;
    }

}
