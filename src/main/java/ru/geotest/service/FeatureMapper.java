package ru.geotest.service;

import com.vividsolutions.jts.geom.Geometry;
import org.springframework.stereotype.Service;
import ru.geotest.dao.FeatureEntity;
import ru.geotest.dto.Feature;
import ru.geotest.dto.PropertySet;

@Service
public class FeatureMapper {

    public FeatureEntity fromDto(Feature featureDto) {
        FeatureEntity featureEntity = new FeatureEntity();

        featureEntity.setGeometry((Geometry)featureDto.getGeometry().clone());
        featureEntity.setClassId(featureDto.getPropertySet().getClassId());
        featureEntity.setFeatureId(featureDto.getPropertySet().getFeatureId());

        return featureEntity;
    }

    public Feature fromEntity(FeatureEntity featureEntity) {
        Feature featureDto = new Feature();

        featureDto.setGeometry((Geometry)featureEntity.getGeometry().clone());
        featureDto.setPropertySet(new PropertySet());
        featureDto.getPropertySet().setClassId(featureEntity.getClassId());
        featureDto.getPropertySet().setFeatureId(featureEntity.getFeatureId());

        return featureDto;
    }
}
