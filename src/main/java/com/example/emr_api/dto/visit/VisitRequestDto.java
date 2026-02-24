package com.example.emr_api.dto.visit;

import com.example.emr_api.enums.VisitStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitRequestDto {
    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotNull(message = "Visit date is required")
    private LocalDateTime visitDate;

    @NotNull(message = "Status is required")
    private VisitStatusEnum status;

}
