package com.example.fishinglicense.mapper;

import com.example.fishinglicense.dto.LicenseRequest;
import com.example.fishinglicense.dto.LicenseResponse;
import com.example.fishinglicense.model.FishingArea;
import com.example.fishinglicense.model.License;
import com.example.fishinglicense.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T16:01:09+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class LicenseMapperImpl implements LicenseMapper {

    @Override
    public License toEntity(LicenseRequest licenseRequest) {
        if ( licenseRequest == null ) {
            return null;
        }

        License.LicenseBuilder license = License.builder();

        license.user( licenseRequestToUser( licenseRequest ) );
        license.fishingArea( licenseRequestToFishingArea( licenseRequest ) );
        license.licenseNumber( licenseRequest.getLicenseNumber() );
        license.issueDate( licenseRequest.getIssueDate() );
        license.expiryDate( licenseRequest.getExpiryDate() );

        return license.build();
    }

    @Override
    public LicenseResponse toResponse(License license) {
        if ( license == null ) {
            return null;
        }

        LicenseResponse licenseResponse = new LicenseResponse();

        licenseResponse.setUserId( licenseUserId( license ) );
        licenseResponse.setFishingAreaId( licenseFishingAreaId( license ) );
        licenseResponse.setId( license.getId() );
        licenseResponse.setLicenseNumber( license.getLicenseNumber() );
        licenseResponse.setIssueDate( license.getIssueDate() );
        licenseResponse.setExpiryDate( license.getExpiryDate() );

        return licenseResponse;
    }

    protected User licenseRequestToUser(LicenseRequest licenseRequest) {
        if ( licenseRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( licenseRequest.getUserId() );

        return user.build();
    }

    protected FishingArea licenseRequestToFishingArea(LicenseRequest licenseRequest) {
        if ( licenseRequest == null ) {
            return null;
        }

        FishingArea.FishingAreaBuilder fishingArea = FishingArea.builder();

        fishingArea.id( licenseRequest.getFishingAreaId() );

        return fishingArea.build();
    }

    private Long licenseUserId(License license) {
        User user = license.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private Long licenseFishingAreaId(License license) {
        FishingArea fishingArea = license.getFishingArea();
        if ( fishingArea == null ) {
            return null;
        }
        return fishingArea.getId();
    }
}
