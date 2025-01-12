package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.LicenseRequest;
import com.example.fishinglicense.dto.LicenseResponse;
import com.example.fishinglicense.model.License;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LicenseMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "fishingAreaId", target = "fishingArea.id")
    License toEntity(LicenseRequest licenseRequest);
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "fishingArea.id", target = "fishingAreaId")
    LicenseResponse toResponse(License license);
}
