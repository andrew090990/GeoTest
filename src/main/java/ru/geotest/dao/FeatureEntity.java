package ru.geotest.dao;

import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "feature")
public class FeatureEntity implements Serializable {

    @Id
    @Column(name = "feature_id")
    private Long featureId;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "geometry")
    private Geometry geometry;

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
