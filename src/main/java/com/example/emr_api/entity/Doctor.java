package com.example.emr_api.entity;

import com.example.medicoreCommonLib.constant.ValidationConstants;
import com.example.medicoreCommonLib.dto.BaseEntity;
import com.example.medicoreCommonLib.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "first_name", nullable = false, length = ValidationConstants.FIRST_NAME_MAX_LENGTH)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = ValidationConstants.LAST_NAME_MAX_LENGTH)
    private String lastName;
    @Column(name = "license_number", nullable = false, unique = true, length = ValidationConstants.LICENSE_NUMBER_MAX_LENGTH)
    private String licenseNumber;
    @Column(name = "specialization", length = ValidationConstants.SPECIALIZATION_MAX_LENGTH)
    private String specialization;
    @Column(name = "phone_number", length = ValidationConstants.PHONE_NUMBER_MAX_LENGTH)
    private String phoneNumber;
    @Column(name = "email", length = ValidationConstants.EMAIL_MAX_LENGTH)
    private String email;
    @Column(name = "gender", length = ValidationConstants.GENDER_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Visit> visits;

}
