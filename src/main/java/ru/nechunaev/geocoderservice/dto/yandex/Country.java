
package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("AddressLine")
    private String mAddressLine;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea mAdministrativeArea;
    @JsonProperty("CountryName")
    private String mCountryName;
    @JsonProperty("CountryNameCode")
    private String mCountryNameCode;

    public String getAddressLine() {
        return mAddressLine;
    }

    public void setAddressLine(String addressLine) {
        mAddressLine = addressLine;
    }

    public AdministrativeArea getAdministrativeArea() {
        return mAdministrativeArea;
    }

    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        mAdministrativeArea = administrativeArea;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public void setCountryName(String countryName) {
        mCountryName = countryName;
    }

    public String getCountryNameCode() {
        return mCountryNameCode;
    }

    public void setCountryNameCode(String countryNameCode) {
        mCountryNameCode = countryNameCode;
    }

}
