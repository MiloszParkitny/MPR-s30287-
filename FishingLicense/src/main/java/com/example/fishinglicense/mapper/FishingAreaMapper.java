package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.FishingAreaRequest;
import com.example.fishinglicense.dto.FishingAreaResponse;
import com.example.fishinglicense.model.FishingArea;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FishingAreaMapper {
    FishingArea toEntity(FishingAreaRequest fishingAreaRequest);
    FishingAreaResponse toResponse(FishingArea fishingArea);
}
