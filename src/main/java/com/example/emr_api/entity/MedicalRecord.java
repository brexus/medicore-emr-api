package com.example.emr_api.entity;

import com.example.medicalCommonLibrary.BaseEntity;
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
@Table(name = "medical_records")
public class MedicalRecord extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;

    @Column(name = "symptoms", columnDefinition = "TEXT")
    private String symptoms;
    @Column(name = "physical_examination", columnDefinition = "TEXT")
    private String physicalExamination;
    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;
    @Column(name = "recommendations", columnDefinition = "TEXT")
    private String recommendations;

}
