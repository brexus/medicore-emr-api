package com.example.emr_api.dto.labOrder;

import com.example.emr_api.enums.LabOrderStatusEnum;
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
public class LabOrderRequestDto {
    @NotNull(message = "Visit ID is required")
    private Long visitId;

    @NotBlank(message = "Test name is required")
    @Size(max = ValidationConstants.TEST_NAME_MAX_LENGTH, message = "Test name must be at most " + ValidationConstants.TEST_NAME_MAX_LENGTH + " characters")
    private String testName;

    @NotNull(message = "Status is required")
//    @Size(max = ValidationConstants.STATUS_MAX_LENGTH, message = "Status must be at most " + ValidationConstants.STATUS_MAX_LENGTH + " characters")
    private LabOrderStatusEnum status;

    @NotBlank(message = "Access code is required")
    @Size(max = ValidationConstants.ACCESS_CODE_MAX_LENGTH, message = "Access code must be at most " + ValidationConstants.ACCESS_CODE_MAX_LENGTH + " characters")
    private String accessCode;

    @Size(max = ValidationConstants.RESULT_PDF_URL_MAX_LENGTH, message = "Result PDF URL must be at most " + ValidationConstants.RESULT_PDF_URL_MAX_LENGTH + " characters")
    private String resultPdfUrl;

}
