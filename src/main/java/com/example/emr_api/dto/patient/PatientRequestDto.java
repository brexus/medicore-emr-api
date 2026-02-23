package com.example.emr_api.dto.patient;

import com.example.emr_api.dto.address.AddressRequestDto;
import com.example.emr_api.enums.GenderEnum;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {
    private AddressRequestDto address;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be at most 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    private String lastName;

    @NotBlank(message = "PESEL is required")
    @Size(max = ValidationConstants.PESEL_LENGTH, message = "PESEL must be exactly " + ValidationConstants.PESEL_LENGTH + " characters")
    private String pesel;

    private String dateOfBirth;

    @Size(max = ValidationConstants.EMAIL_MAX_LENGTH, message = "Email must be at most " + ValidationConstants.EMAIL_MAX_LENGTH + " characters")
    private String email;

    @Size(max = ValidationConstants.PHONE_NUMBER_MAX_LENGTH, message = "Phone number must be at most " + ValidationConstants.PHONE_NUMBER_MAX_LENGTH + " characters")
    private String phoneNumber;

    @NotNull(message = "Gender is required")
    private GenderEnum gender;

}
