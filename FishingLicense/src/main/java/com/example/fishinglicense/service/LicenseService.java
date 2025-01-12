package com.example.fishinglicense.service;

import com.example.fishinglicense.dto.LicenseRequest;
import com.example.fishinglicense.dto.LicenseResponse;
import com.example.fishinglicense.mapper.LicenseMapper;
import com.example.fishinglicense.model.License;
import com.example.fishinglicense.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository licenseRepository;
    private final LicenseMapper licenseMapper;

    public List<LicenseResponse> getAllLicenses() {
        return licenseRepository.findAll()
                .stream()
                .map(licenseMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LicenseResponse getLicenseById(Long id) {
        License license = licenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("License not found with id: " + id));
        return licenseMapper.toResponse(license);
    }

    public LicenseResponse createLicense(LicenseRequest licenseRequest) {
        License license = licenseMapper.toEntity(licenseRequest);
        License savedLicense = licenseRepository.save(license);
        return licenseMapper.toResponse(savedLicense);
    }

    public LicenseResponse updateLicense(Long id, LicenseRequest licenseRequest) {
        return licenseRepository.findById(id)
                .map(license -> {
                    license.setLicenseNumber(licenseRequest.getLicenseNumber());
                    license.setIssueDate(licenseRequest.getIssueDate());
                    license.setExpiryDate(licenseRequest.getExpiryDate());
                    return licenseMapper.toResponse(licenseRepository.save(license));
                })
                .orElseThrow(() -> new RuntimeException("License not found with id: " + id));
    }

    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }
    public LicenseResponse getLicenseByLicenseNumber(String licenseNumber) {
        License license = licenseRepository.findByLicenseNumber(licenseNumber)
                .orElseThrow(() -> new RuntimeException("License not found with number: " + licenseNumber));
        return licenseMapper.toResponse(license);
    }

    public List<LicenseResponse> getLicensesByUserId(Long userId) {
        return licenseRepository.findByUserId(userId)
                .stream()
                .map(licenseMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<LicenseResponse> getLicensesByFishingAreaId(Long fishingAreaId) {
        return licenseRepository.findByFishingAreaId(fishingAreaId)
                .stream()
                .map(licenseMapper::toResponse)
                .collect(Collectors.toList());
    }

}
