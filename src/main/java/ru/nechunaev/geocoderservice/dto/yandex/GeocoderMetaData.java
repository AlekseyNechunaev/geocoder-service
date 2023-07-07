package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocoderMetaData {

    @JsonProperty("Address")
    private Address mAddress;
    @JsonProperty("AddressDetails")
    private AddressDetails mAddressDetails;
    @JsonProperty("kind")
    private String mKind;
    @JsonProperty("precision")
    private String mPrecision;
    @JsonProperty("text")
    private String mText;

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public AddressDetails getAddressDetails() {
        return mAddressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        mAddressDetails = addressDetails;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }

    public String getPrecision() {
        return mPrecision;
    }

    public void setPrecision(String precision) {
        mPrecision = precision;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
