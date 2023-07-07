package ru.nechunaev.geocoderservice.dto.yandex;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty("Components")
    private List<Component> mComponents;
    @JsonProperty("country_code")
    private String mCountryCode;
    @JsonProperty("formatted")
    private String mFormatted;
    @JsonProperty("postal_code")
    private String mPostalCode;

    public List<Component> getComponents() {
        return mComponents;
    }

    public void setComponents(List<Component> components) {
        mComponents = components;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
    }

    public String getFormatted() {
        return mFormatted;
    }

    public void setFormatted(String formatted) {
        mFormatted = formatted;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

}
