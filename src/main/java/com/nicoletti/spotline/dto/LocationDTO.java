package com.nicoletti.spotline.dto;

import com.nicoletti.spotline.model.LocationEntity;

public record LocationDTO (String userId, Double latitude, Double longitude, Long timestamp) {

    public static LocationDTO from(LocationEntity location) {
        return new LocationDTO(
                location.getUserId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp().toEpochMilli()
        );
    }

}
