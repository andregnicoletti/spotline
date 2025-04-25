package com.nicoletti.spotline.service;

import com.nicoletti.spotline.model.LocationEntity;
import com.nicoletti.spotline.repository.LocationRepository;
import com.nicoletti.spotline.dto.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    public void save(LocationDTO dto) {

        String url = "https://www.google.com/maps/search/?api=1&query=%s,%s";
        System.out.println(String.format(url, dto.latitude(), dto.longitude()));

        boolean exists = repository.existsByUserIdAndLatitudeAndLongitudeAndTimestamp(
                dto.userId(),
                dto.latitude(),
                dto.longitude(),
                Instant.ofEpochMilli(dto.timestamp())
        );

        if(!exists){
            LocationEntity location = LocationEntity.builder()
                    .userId(dto.userId())
                    .latitude(dto.latitude())
                    .longitude(dto.longitude())
                    .timestamp(Instant.ofEpochMilli(dto.timestamp()))
                    .build();

            repository.save(location);
        }
    }

    public List<LocationDTO> getLocationsByUserAndDateRange(String userId, Instant start, Instant end) {

        return repository
                .findByUserIdAndTimestampBetweenOrderByTimestampAsc(userId, start, end)
                .stream()
                .map(LocationDTO::from)
                .toList();

    }

    public List<String> listAllUsersId() {
        return repository.findAllDistinctUserIds();
    }
}