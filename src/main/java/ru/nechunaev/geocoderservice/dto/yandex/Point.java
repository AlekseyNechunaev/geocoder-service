package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {

    @JsonProperty("pos")
    private String mPos;

    public String getPos() {
        return mPos;
    }

    public void setPos(String pos) {
        mPos = pos;
    }

}
