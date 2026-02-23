package com.example.emr_api.entity;

import com.example.emr_api.enums.AppointmentStatusEnum;
import com.example.medicalCommonLibrary.BaseEntity;
import com.example.medicalCommonLibrary.constant.ValidationConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;
    @Column(name = "status", nullable = false, length = ValidationConstants.STATUS_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum status;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private MedicalRecord medicalRecord;
    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptionList;
    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LabOrder> labOrderList;
}
