package ru.geotest.repository;

import com.vividsolutions.jts.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.geotest.dao.FeatureEntity;

import java.util.List;

public interface FeatureRepository extends CrudRepository<FeatureEntity, Long> {

    @Query("select f from FeatureEntity f where within(f.geometry, ?1) = true and (?2 = 0L or f.classId = ?2)")
    public List<FeatureEntity> findInArea(Geometry area, Long classId);
}
