package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministrativeArea {

    @JsonProperty("AdministrativeAreaName")
    private String mAdministrativeAreaName;
    @JsonProperty("Locality")
    private Locality mLocality;

    public String getAdministrativeAreaName() {
        return mAdministrativeAreaName;
    }

    public void setAdministrativeAreaName(String administrativeAreaName) {
        mAdministrativeAreaName = administrativeAreaName;
    }

    public Locality getLocality() {
        return mLocality;
    }

    public void setLocality(Locality locality) {
        mLocality = locality;
    }

}
