package com.nicoletti.spotline.controller;

import com.nicoletti.spotline.dto.LocationDTO;
import com.nicoletti.spotline.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/location")
public class WebhookController {

    private final LocationService service;

    @PostMapping
    public ResponseEntity<Void> location(@RequestBody LocationDTO location) {
        service.save(location);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public List<LocationDTO> getLocationsByUserAndDateRange(@RequestParam String userId,
                                                            @RequestParam Instant start,
                                                            @RequestParam Instant end) {
        return service.getLocationsByUserAndDateRange(userId, start, end);
    }

    @GetMapping("/users")
    ResponseEntity<List<String>> getAlluserIds() {
        List<String> ids = service.listAllUsersId();
        return ResponseEntity.ok(ids);
    }

}


