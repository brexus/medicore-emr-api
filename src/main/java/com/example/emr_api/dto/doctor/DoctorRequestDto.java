package com.example.emr_api.dto.doctor;

import com.example.emr_api.enums.GenderEnum;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {
    private Long addressId;

    @NotBlank(message = "First name is required")
    @Size(max = ValidationConstants.FIRST_NAME_MAX_LENGTH, message = "First name must be at most " + ValidationConstants.FIRST_NAME_MAX_LENGTH + " characters")
    @Pattern(regexp = ValidationConstants.FIRST_NAME_REGEX, message = "First name contains invalid characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = ValidationConstants.LAST_NAME_MAX_LENGTH, message = "Last name must be at most " + ValidationConstants.LAST_NAME_MAX_LENGTH + " characters")
    @Pattern(regexp = ValidationConstants.LAST_NAME_REGEX, message = "Last name contains invalid characters")
    private String lastName;

    @NotBlank(message = "License number is required")
    @Size(max = ValidationConstants.LICENSE_NUMBER_MAX_LENGTH, message = "License number must be at most " + ValidationConstants.LICENSE_NUMBER_MAX_LENGTH + " characters")
    @Pattern(regexp = ValidationConstants.LICENSE_NUMBER_REGEX, message = "License number must be exactly " + ValidationConstants.LICENSE_NUMBER_MAX_LENGTH + " digits")
    private String licenseNumber;

    @NotBlank(message = "Specialization is required")
    @Size(max = ValidationConstants.SPECIALIZATION_MAX_LENGTH, message = "Specialization must be at most " + ValidationConstants.SPECIALIZATION_MAX_LENGTH + " characters")
    private String specialization;

    @Size(max = ValidationConstants.PHONE_NUMBER_MAX_LENGTH, message = "Phone number must be at most " + ValidationConstants.PHONE_NUMBER_MAX_LENGTH + " characters")
    @Pattern(regexp = ValidationConstants.PHONE_NUMBER_REGEX, message = "Phone number must be a valid format")
    private String phoneNumber;

    @Size(max = ValidationConstants.EMAIL_MAX_LENGTH, message = "Email must be at most " + ValidationConstants.EMAIL_MAX_LENGTH + " characters")
    @Pattern(regexp = ValidationConstants.EMAIL_REGEX, message = "Email must be a valid format")
    private String email;

    @NotNull(message = "Gender is required")
    private GenderEnum gender;

}
