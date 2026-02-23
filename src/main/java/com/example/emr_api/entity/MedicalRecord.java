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
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;

    @Column(name = "symptoms", columnDefinition = "TEXT")
    private String symptoms;
    @Column(name = "physical_examination", columnDefinition = "TEXT")
    private String physicalExamination;
    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;
    @Column(name = "recommendations", columnDefinition = "TEXT")
    private String recommendations;

}
