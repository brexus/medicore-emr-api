package com.example.emr_api.entity;

import com.example.emr_api.enums.LabOrderStatusEnum;
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
@Table(name = "lab_orders")
public class LabOrder extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(name = "test_name", nullable = false, length = ValidationConstants.TEST_NAME_MAX_LENGTH)
    private String testName;
    @Column(name = "status", nullable = false, length = ValidationConstants.STATUS_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private LabOrderStatusEnum status;
    @Column(name = "access_code", nullable = false, length = ValidationConstants.ACCESS_CODE_MAX_LENGTH)
    private String accessCode;
    @Column(name = "result_pdf_url", nullable = true, length = ValidationConstants.RESULT_PDF_URL_MAX_LENGTH)
    private String resultPdfUrl;
}
