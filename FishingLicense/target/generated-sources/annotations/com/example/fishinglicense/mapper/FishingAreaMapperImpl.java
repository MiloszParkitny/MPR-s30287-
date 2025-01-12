package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.FishingAreaRequest;
import com.example.fishinglicense.dto.FishingAreaResponse;
import com.example.fishinglicense.model.FishingArea;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T16:01:09+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FishingAreaMapperImpl implements FishingAreaMapper {

    @Override
    public FishingArea toEntity(FishingAreaRequest fishingAreaRequest) {
        if ( fishingAreaRequest == null ) {
            return null;
        }

        FishingArea.FishingAreaBuilder fishingArea = FishingArea.builder();

        fishingArea.name( fishingAreaRequest.getName() );
        fishingArea.location( fishingAreaRequest.getLocation() );

        return fishingArea.build();
    }

    @Override
    public FishingAreaResponse toResponse(FishingArea fishingArea) {
        if ( fishingArea == null ) {
            return null;
        }

        FishingAreaResponse fishingAreaResponse = new FishingAreaResponse();

        fishingAreaResponse.setId( fishingArea.getId() );
        fishingAreaResponse.setName( fishingArea.getName() );
        fishingAreaResponse.setLocation( fishingArea.getLocation() );

        return fishingAreaResponse;
    }
}
