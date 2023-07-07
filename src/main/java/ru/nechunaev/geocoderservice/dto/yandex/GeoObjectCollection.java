package ru.nechunaev.geocoderservice.dto.yandex;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoObjectCollection {

    @JsonProperty("featureMember")
    private List<FeatureMember> mFeatureMember;
    @JsonProperty("metaDataProperty")
    private MetaDataProperty mMetaDataProperty;

    public List<FeatureMember> getFeatureMember() {
        return mFeatureMember;
    }

    public void setFeatureMember(List<FeatureMember> featureMember) {
        mFeatureMember = featureMember;
    }

    public MetaDataProperty getMetaDataProperty() {
        return mMetaDataProperty;
    }

    public void setMetaDataProperty(MetaDataProperty metaDataProperty) {
        mMetaDataProperty = metaDataProperty;
    }

}
