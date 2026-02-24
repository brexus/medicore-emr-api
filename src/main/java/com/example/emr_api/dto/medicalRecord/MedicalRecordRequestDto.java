package com.example.emr_api.dto.medicalRecord;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordRequestDto {
    @NotNull(message = "Visit ID is required")
    private Long visitId;

    private String symptoms;

    private String physicalExamination;

    private String diagnosis;

    private String recommendations;

}
