package ru.geotest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.vividsolutions.jts.geom.Geometry;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature implements Serializable {

    @JsonProperty("properties")
    private PropertySet propertySet;

    private Geometry geometry;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public PropertySet getPropertySet() {
        return propertySet;
    }

    public void setPropertySet(PropertySet propertySet) {
        this.propertySet = propertySet;
    }
}
