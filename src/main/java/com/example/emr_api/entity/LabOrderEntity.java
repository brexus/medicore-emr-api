package com.example.emr_api.entity;

import com.example.medicoreCommonLib.constant.ValidationConstants;
import com.example.medicoreCommonLib.dto.BaseEntity;
import com.example.medicoreCommonLib.enums.LabOrderStatusEnum;
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
public class LabOrderEntity extends BaseEntity {
    @Column(name = "test_name", nullable = false, length = ValidationConstants.TEST_NAME_MAX_LENGTH)
    private String testName;

    @Column(name = "status", nullable = false, length = ValidationConstants.STATUS_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private LabOrderStatusEnum status;

    @Column(name = "access_code", nullable = false, length = ValidationConstants.ACCESS_CODE_MAX_LENGTH)
    private String accessCode;

    @Column(name = "result_pdf_url", nullable = true, length = ValidationConstants.RESULT_PDF_URL_MAX_LENGTH)
    private String resultPdfUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", nullable = false)
    private VisitEntity visit;
}
