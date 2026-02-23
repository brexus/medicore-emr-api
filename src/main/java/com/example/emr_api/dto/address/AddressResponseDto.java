package com.example.emr_api.dto.address;

import com.example.medicalCommonLibrary.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto extends BaseDto {
    private String street;
    private String buildingNumber;
    private String apartmentNumber;
    private String city;
    private String zipCode;
    private String country;
}
