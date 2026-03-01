package com.example.emr_api.repository;

import com.example.emr_api.entity.VisitEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity, Long> {
    @EntityGraph(attributePaths = {"patient", "patient.address"})
    List<VisitEntity> findAllByVisitDateBetweenOrderByVisitDateAsc(LocalDateTime startOfDay, LocalDateTime endOfDay);

    @Query("SELECT v FROM VisitEntity v JOIN FETCH v.doctor d WHERE v.patient.id = :patientId")
    List<VisitEntity> findVisitsWithDoctorByPatientId(@Param("patientId") Long patientId);
}
