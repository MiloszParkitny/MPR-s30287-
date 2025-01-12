package com.example.fishinglicense.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LicenseRequest {

    @NotBlank(message = "License number is required")
    private String licenseNumber;

    @NotNull(message = "Issue date is required")
    private LocalDate issueDate;

    @NotNull(message = "Expiry date is required")
    private LocalDate expiryDate;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Fishing Area ID is required")
    private Long fishingAreaId;
}
