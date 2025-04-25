package com.nicoletti.spotline.controller;

import com.nicoletti.spotline.dto.LocationDTO;
import com.nicoletti.spotline.service.LocationService;
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

    private final LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<Void> location(@RequestBody LocationDTO location) {
        locationService.save(location);


        System.out.println("---------------------------------------------------------------");
        String url = "https://www.google.com/maps/search/?api=1&query=%s,%s";
        String local = String.format(url, location.getLatitude(), location.getLongitude());
        System.out.println(local);
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");

        System.out.printf(
                "Lat: %s, Lng: %s, Timestamp: %s%n",
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp()
        );

        return ResponseEntity.ok().build();
    }

}


