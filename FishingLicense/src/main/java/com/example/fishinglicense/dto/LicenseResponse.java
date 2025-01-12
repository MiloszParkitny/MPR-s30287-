package com.example.fishinglicense.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LicenseResponse {
    private Long id;
    private String licenseNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private Long userId;
    private Long fishingAreaId;
}
