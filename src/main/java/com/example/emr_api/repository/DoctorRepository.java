package com.example.emr_api.repository;

import com.example.emr_api.entity.DoctorEntity;
import com.example.medicoreCommonLib.dto.doctor.DoctorResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    @Query("SELECT d FROM DoctorEntity d WHERE " +
            "LOWER(d.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(d.lastName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(CONCAT(d.firstName, ' ', d.lastName)) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(CONCAT(d.lastName, ' ', d.firstName)) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<DoctorEntity> searchDoctorsByFirstNameAndLastName(String query);

}
