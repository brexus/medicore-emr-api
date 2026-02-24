package com.example.emr_api.dto.prescription;

import com.example.emr_api.enums.PrescriptionStatusEnum;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRequestDto {
    @NotNull(message = "Visit ID is required")
    private Long visitId;

    @NotBlank(message = "Medication name is required")
    @Size(max = ValidationConstants.MEDICATION_NAME_MAX_LENGTH, message = "Medication name must be at most " + ValidationConstants.MEDICATION_NAME_MAX_LENGTH + " characters")
    private String medicationName;

    @NotBlank(message = "Dosage is required")
    @Size(max = ValidationConstants.DOSAGE_MAX_LENGTH, message = "Dosage must be at most " + ValidationConstants.DOSAGE_MAX_LENGTH + " characters")
    private String dosage;

    @Min(value = 1, message = "Duration must be at least 1 day")
    @Max(value = 365, message = "Duration cannot exceed 365 days")
    private Integer durationDays;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Status is required")
    private PrescriptionStatusEnum status;

    @NotBlank(message = "Access code is required")
    @Size(max = ValidationConstants.ACCESS_CODE_MAX_LENGTH, message = "Access code must be at most " + ValidationConstants.ACCESS_CODE_MAX_LENGTH + " characters")
    private String accessCode;

}
