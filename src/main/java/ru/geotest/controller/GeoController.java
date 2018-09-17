package ru.geotest.controller;

import com.vividsolutions.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geotest.dto.Feature;
import ru.geotest.service.FeatureService;

import java.util.List;

@RestController
public class GeoController {

    @Autowired
    private FeatureService featureService;

    @PostMapping("/search")
    public List<Feature> getFeatures(
            @RequestBody Geometry area,
            @RequestParam(defaultValue = "0", required = false) Long classId
    ) {
        return featureService.findInArea(area, classId);
    }

    @Transactional
    @PostMapping("/features")
    public void postFeatures(@RequestBody List<Feature> features) {
        featureService.saveFeatures(features);
    }
}
