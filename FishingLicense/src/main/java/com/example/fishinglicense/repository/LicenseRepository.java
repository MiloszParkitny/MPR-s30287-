package com.example.fishinglicense.repository;

import com.example.fishinglicense.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License, Long> {
    Optional<License> findByLicenseNumber(String licenseNumber);
    List<License> findByUserId(Long userId);
    List<License> findByFishingAreaId(Long fishingAreaId);
}
