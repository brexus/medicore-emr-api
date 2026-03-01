package com.example.emr_api.service.impl;

import com.example.emr_api.entity.DoctorEntity;
import com.example.emr_api.entity.MedicalRecordEntity;
import com.example.emr_api.entity.PatientEntity;
import com.example.emr_api.entity.VisitEntity;
import com.example.emr_api.mapper.MedicalRecordMapper;
import com.example.emr_api.mapper.VisitMapper;
import com.example.emr_api.repository.DoctorRepository;
import com.example.emr_api.repository.PatientRepository;
import com.example.emr_api.repository.VisitRepository;
import com.example.emr_api.service.VisitService;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordRequestDto;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitBasicResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import com.example.medicoreCommonLib.enums.VisitStatusEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final MedicalRecordMapper medicalRecordMapper;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<VisitBasicResponseDto> getTodayVisits() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
        List<VisitEntity> visitList = visitRepository.findAllByVisitDateBetweenOrderByVisitDateAsc(startOfDay, endOfDay);
        return visitMapper.toBasicDtoList(visitList);
    }

    @Override
    public VisitResponseDto getVisitById(Long id) {
        VisitEntity visit = visitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + id));
        return visitMapper.toDto(visit);
    }

    @Override
    public VisitResponseDto createVisit(VisitRequestDto reqDto) {
        VisitEntity visit = visitMapper.toEntity(reqDto);
        PatientEntity patient = patientRepository.findById(reqDto.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found with id: " + reqDto.getPatientId()));
        visit.setPatient(patient);
        DoctorEntity doctor = doctorRepository.findById(reqDto.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + reqDto.getDoctorId()));
        visit.setDoctor(doctor);
        
        VisitEntity savedVisit = visitRepository.save(visit);
        return visitMapper.toDto(savedVisit);
    }

    @Override
    @Transactional
    public MedicalRecordResponseDto upsertMedicalRecord(MedicalRecordRequestDto reqDto) {
        VisitEntity visit = visitRepository.findById(reqDto.getVisitId())
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + reqDto.getVisitId()));

        MedicalRecordEntity medicalRecordToSave;

        if (visit.getMedicalRecord() != null) {
            medicalRecordToSave = visit.getMedicalRecord();
            medicalRecordToSave.setSymptoms(reqDto.getSymptoms());
            medicalRecordToSave.setPhysicalExamination(reqDto.getPhysicalExamination());
            medicalRecordToSave.setDiagnosis(reqDto.getDiagnosis());
            medicalRecordToSave.setRecommendations(reqDto.getRecommendations());
        } else {
            medicalRecordToSave = medicalRecordMapper.toEntity(reqDto);
            visit.setMedicalRecord(medicalRecordToSave);
        }

        VisitEntity savedVisit = visitRepository.save(visit);
        return medicalRecordMapper.toDto(savedVisit.getMedicalRecord());
    }

    @Override
    public MedicalRecordResponseDto getMedicalRecordByVisitId(Long visitId) {
        VisitEntity visit = visitRepository.findById(visitId).orElseThrow(() -> new RuntimeException("Visit not found with id: " + visitId));
        MedicalRecordEntity medicalRecord = visit.getMedicalRecord();
        return medicalRecordMapper.toDto(medicalRecord);
    }

    @Override
    @Transactional
    public Void changeVisitStatus(Long visitId, VisitStatusEnum status) {
        VisitEntity visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + visitId));

        visit.setStatus(status);
        visitRepository.save(visit);

        return null;
    }


}
