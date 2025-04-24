package com.nicoletti.spotline.controller;

import com.nicoletti.spotline.dto.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/webhook")
public class WebhookController {

    @PostMapping("/location")
    public ResponseEntity<Void> location(@RequestBody LocationDTO location) {
        System.out.printf("Lat: %s, Lng: %s, Timestamp: %s%n",
                location.getLatitude(), location.getLongitude(), location.getTimestamp());
        return ResponseEntity.ok().build();
    }

}


