package com.example.fishinglicense.controller;

import com.example.fishinglicense.dto.FishingAreaRequest;
import com.example.fishinglicense.dto.FishingAreaResponse;
import com.example.fishinglicense.service.FishingAreaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fishing-areas")
@RequiredArgsConstructor
public class FishingAreaController {

    private final FishingAreaService fishingAreaService;

    @GetMapping
    public ResponseEntity<List<FishingAreaResponse>> getAllFishingAreas() {
        return ResponseEntity.ok(fishingAreaService.getAllFishingAreas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FishingAreaResponse> getFishingAreaById(@PathVariable Long id) {
        return ResponseEntity.ok(fishingAreaService.getFishingAreaById(id));
    }

    @PostMapping
    public ResponseEntity<FishingAreaResponse> createFishingArea(@Valid @RequestBody FishingAreaRequest fishingAreaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fishingAreaService.createFishingArea(fishingAreaRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FishingAreaResponse> updateFishingArea(@PathVariable Long id, @Valid @RequestBody FishingAreaRequest fishingAreaRequest) {
        return ResponseEntity.ok(fishingAreaService.updateFishingArea(id, fishingAreaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFishingArea(@PathVariable Long id) {
        fishingAreaService.deleteFishingArea(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-name")
    public ResponseEntity<FishingAreaResponse> getFishingAreaByName(@RequestParam String name) {
        return ResponseEntity.ok(fishingAreaService.getFishingAreaByName(name));
    }


}
