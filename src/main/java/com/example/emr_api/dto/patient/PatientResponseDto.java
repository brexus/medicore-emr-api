package com.example.emr_api.dto.patient;

import com.example.emr_api.dto.address.AddressRequestDto;
import com.example.emr_api.dto.address.AddressResponseDto;
import com.example.medicalCommonLibrary.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PatientResponseDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String pesel;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String gender;
    private AddressResponseDto address;
}
