package com.example.emr_api.dto.address;

import com.example.medicalCommonLibrary.BaseDto;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto extends BaseDto {

    @Size(max = ValidationConstants.STREET_MAX_LENGTH, message = "Street name must be at most 100 characters")
    private String street;

    @Size(max = ValidationConstants.BUILDING_NUMBER_MAX_LENGTH, message = "Building number must be at most 10 characters")
    @NotBlank(message = "Building number is required")
    private String buildingNumber;

    @Size(max = ValidationConstants.APARTMENT_NUMBER_MAX_LENGTH, message = "Apartment number must be at most 10 characters")
    private String apartmentNumber;

    @Size(max = ValidationConstants.CITY_MAX_LENGTH, message = "City name must be at most 100 characters")
    @NotBlank(message = "City is required")
    private String city;

    @Size(max = ValidationConstants.ZIP_CODE_LENGTH, message = "Zip code must be at most 12 characters")
    @NotBlank(message = "Zip code is required")
    private String zipCode;

    @Size(max = ValidationConstants.COUNTRY_MAX_LENGTH, message = "Country name must be at most 50 characters")
    @NotBlank(message = "Country is required")
    private String country;

}
