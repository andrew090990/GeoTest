package ru.geotest.service;

import com.vividsolutions.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geotest.dto.Feature;
import ru.geotest.repository.FeatureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository repository;

    @Autowired
    private FeatureMapper mapper;

    public void saveFeatures(List<Feature> features) {

        features.stream()
                .map(mapper::fromDto)
                .forEach(repository::save);
    }

    public List<Feature> findInArea(Geometry area, Long classId) {

        return repository.findInArea(area, classId)
                .stream()
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }
}
