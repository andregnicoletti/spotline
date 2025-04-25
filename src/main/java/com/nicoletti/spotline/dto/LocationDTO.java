package com.nicoletti.spotline.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private String userId;
    private double latitude;
    private double longitude;
    private long timestamp;
}
