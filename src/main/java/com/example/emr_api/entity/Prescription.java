package com.example.emr_api.entity;

import com.example.emr_api.enums.PrescriptionStatusEnum;
import com.example.medicalCommonLibrary.BaseEntity;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prescriptions")
public class Prescription extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(name = "medication_name", nullable = false, length = ValidationConstants.MEDICATION_NAME_MAX_LENGTH)
    private String medicationName;
    @Column(name = "dosage", nullable = false, length = ValidationConstants.DOSAGE_MAX_LENGTH)
    private String dosage;
    @Column(name = "duration_days")
    private Integer durationDays;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "status", nullable = false, length = ValidationConstants.STATUS_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private PrescriptionStatusEnum status;
    @Column(name = "access_code", nullable = false, length = ValidationConstants.ACCESS_CODE_MAX_LENGTH)
    private String accessCode;

}
