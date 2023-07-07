package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;
public class BoundedBy {

    @JsonProperty("Envelope")
    private Envelope mEnvelope;

    public Envelope getEnvelope() {
        return mEnvelope;
    }

    public void setEnvelope(Envelope envelope) {
        mEnvelope = envelope;
    }

}
