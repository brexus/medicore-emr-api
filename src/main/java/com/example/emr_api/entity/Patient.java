package com.example.emr_api.entity;

import com.example.medicoreCommonLib.constant.ValidationConstants;
import com.example.medicoreCommonLib.dto.BaseEntity;
import com.example.medicoreCommonLib.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "first_name", nullable = false, length = ValidationConstants.FIRST_NAME_MAX_LENGTH)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = ValidationConstants.LAST_NAME_MAX_LENGTH)
    private String lastName;
    @Column(name = "pesel", nullable = false, unique = true, length = ValidationConstants.PESEL_LENGTH)
    private String pesel;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "email", length = ValidationConstants.EMAIL_MAX_LENGTH)
    private String email;
    @Column(name = "phone_number", length = ValidationConstants.PHONE_NUMBER_MAX_LENGTH)
    private String phoneNumber;
    @Column(name = "gender", length = ValidationConstants.GENDER_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Visit> visits;

    @Transient
    public Integer getAge() {
        if (this.dateOfBirth == null) {
            return null;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

//        W PRZYSZŁOŚCI
//        4. MEDICAL HISTORY???
//       5. INSURANCE DETAILS??
//        6. EMERGENCY CONTACTS??
}
