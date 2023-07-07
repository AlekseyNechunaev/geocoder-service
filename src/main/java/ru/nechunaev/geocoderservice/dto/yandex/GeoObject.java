package ru.nechunaev.geocoderservice.dto.yandex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoObject {

    @JsonProperty("boundedBy")
    private BoundedBy mBoundedBy;
    @JsonProperty("description")
    private String mDescription;
    @JsonProperty("metaDataProperty")
    private MetaDataProperty mMetaDataProperty;
    @JsonProperty("name")
    private String mName;
    @JsonProperty("Point")
    private Point mPoint;

    public BoundedBy getBoundedBy() {
        return mBoundedBy;
    }

    public void setBoundedBy(BoundedBy boundedBy) {
        mBoundedBy = boundedBy;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public MetaDataProperty getMetaDataProperty() {
        return mMetaDataProperty;
    }

    public void setMetaDataProperty(MetaDataProperty metaDataProperty) {
        mMetaDataProperty = metaDataProperty;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Point getPoint() {
        return mPoint;
    }

    public void setPoint(Point point) {
        mPoint = point;
    }

}
