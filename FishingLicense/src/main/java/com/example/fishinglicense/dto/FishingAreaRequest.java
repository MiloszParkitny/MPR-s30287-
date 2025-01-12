package com.example.fishinglicense.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FishingAreaRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;
}