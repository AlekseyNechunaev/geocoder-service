package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocoderResponseMetaData {

    @JsonProperty("found")
    private String mFound;
    @JsonProperty("Point")
    private Point mPoint;
    @JsonProperty("request")
    private String mRequest;
    @JsonProperty("results")
    private String mResults;

    public String getFound() {
        return mFound;
    }

    public void setFound(String found) {
        mFound = found;
    }

    public Point getPoint() {
        return mPoint;
    }

    public void setPoint(Point point) {
        mPoint = point;
    }

    public String getRequest() {
        return mRequest;
    }

    public void setRequest(String request) {
        mRequest = request;
    }

    public String getResults() {
        return mResults;
    }

    public void setResults(String results) {
        mResults = results;
    }

}
