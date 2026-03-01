package com.example.emr_api.entity;

import com.example.medicoreCommonLib.constant.ValidationConstants;
import com.example.medicoreCommonLib.dto.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class AddressEntity extends BaseEntity {
    @Column(name = "street", length = ValidationConstants.STREET_MAX_LENGTH)
    private String street;

    @Column(name = "building_number", nullable = false, length = ValidationConstants.BUILDING_NUMBER_MAX_LENGTH)
    private String buildingNumber;

    @Column(name = "apartment_number", length = ValidationConstants.APARTMENT_NUMBER_MAX_LENGTH)
    private String apartmentNumber;

    @Column(name = "city", nullable = false, length = ValidationConstants.CITY_MAX_LENGTH)
    private String city;

    @Column(name = "zip_code", nullable = false, length = ValidationConstants.ZIP_CODE_LENGTH)
    private String zipCode;

    @Column(name = "country", nullable = false, length = ValidationConstants.COUNTRY_MAX_LENGTH)
    private String country;


    @OneToOne(mappedBy = "address")
    private DoctorEntity doctor;

    @OneToOne(mappedBy = "address")
    private PatientEntity patient;
}
