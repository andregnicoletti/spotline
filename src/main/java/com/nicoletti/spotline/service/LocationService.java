package com.nicoletti.spotline.service;

import com.nicoletti.spotline.model.LocationEntity;
import com.nicoletti.spotline.repository.LocationRepository;
import com.nicoletti.spotline.dto.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    public void save(LocationDTO dto) {

        LocationEntity location = LocationEntity.builder()
                .userId(dto.getUserId())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .timestamp(Instant.ofEpochMilli(dto.getTimestamp()))
                .build();

        repository.save(location);
    }
}