package com.nicoletti.spotline.repository;

import com.nicoletti.spotline.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}