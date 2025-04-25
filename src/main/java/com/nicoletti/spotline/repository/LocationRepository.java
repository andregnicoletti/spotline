package com.nicoletti.spotline.repository;

import com.nicoletti.spotline.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

    List<LocationEntity> findByUserIdAndTimestampBetweenOrderByTimestampAsc(String userId, Instant start, Instant end);

    boolean existsByUserIdAndLatitudeAndLongitudeAndTimestamp(String userId, Double latitude, Double longitude, Instant timestamp);

    @Query("SELECT DISTINCT l.userId FROM LocationEntity l")
    List<String> findAllDistinctUserIds();

}