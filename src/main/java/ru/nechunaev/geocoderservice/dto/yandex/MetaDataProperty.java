package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaDataProperty {

    @JsonProperty("GeocoderMetaData")
    private GeocoderMetaData mGeocoderMetaData;
    @JsonProperty("GeocoderResponseMetaData")
    private GeocoderResponseMetaData mGeocoderResponseMetaData;

    public GeocoderMetaData getGeocoderMetaData() {
        return mGeocoderMetaData;
    }

    public void setGeocoderMetaData(GeocoderMetaData geocoderMetaData) {
        mGeocoderMetaData = geocoderMetaData;
    }

    public GeocoderResponseMetaData getGeocoderResponseMetaData() {
        return mGeocoderResponseMetaData;
    }

    public void setGeocoderResponseMetaData(GeocoderResponseMetaData geocoderResponseMetaData) {
        mGeocoderResponseMetaData = geocoderResponseMetaData;
    }

}
