package com.example.fishinglicense.controller;

import com.example.fishinglicense.dto.LicenseRequest;
import com.example.fishinglicense.dto.LicenseResponse;
import com.example.fishinglicense.service.LicenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licenses")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;

    @GetMapping
    public ResponseEntity<List<LicenseResponse>> getAllLicenses() {
        return ResponseEntity.ok(licenseService.getAllLicenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicenseResponse> getLicenseById(@PathVariable Long id) {
        return ResponseEntity.ok(licenseService.getLicenseById(id));
    }

    @PostMapping
    public ResponseEntity<LicenseResponse> createLicense(@Valid @RequestBody LicenseRequest licenseRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(licenseService.createLicense(licenseRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LicenseResponse> updateLicense(@PathVariable Long id, @Valid @RequestBody LicenseRequest licenseRequest) {
        return ResponseEntity.ok(licenseService.updateLicense(id, licenseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicense(@PathVariable Long id) {
        licenseService.deleteLicense(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/by-number")
    public ResponseEntity<LicenseResponse> getLicenseByLicenseNumber(@RequestParam String licenseNumber) {
        return ResponseEntity.ok(licenseService.getLicenseByLicenseNumber(licenseNumber));
    }

    @GetMapping("/by-user")
    public ResponseEntity<List<LicenseResponse>> getLicensesByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(licenseService.getLicensesByUserId(userId));
    }

    @GetMapping("/by-area")
    public ResponseEntity<List<LicenseResponse>> getLicensesByFishingAreaId(@RequestParam Long fishingAreaId) {
        return ResponseEntity.ok(licenseService.getLicensesByFishingAreaId(fishingAreaId));
    }
}
