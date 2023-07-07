package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Premise {

    @JsonProperty("PostalCode")
    private PostalCode mPostalCode;
    @JsonProperty("PremiseNumber")
    private String mPremiseNumber;

    public PostalCode getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        mPostalCode = postalCode;
    }

    public String getPremiseNumber() {
        return mPremiseNumber;
    }

    public void setPremiseNumber(String premiseNumber) {
        mPremiseNumber = premiseNumber;
    }

}
