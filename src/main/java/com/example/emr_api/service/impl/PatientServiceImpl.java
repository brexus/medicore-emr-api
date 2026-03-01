package com.example.emr_api.service.impl;

import com.example.emr_api.entity.PatientEntity;
import com.example.emr_api.entity.VisitEntity;
import com.example.emr_api.mapper.PatientMapper;
import com.example.emr_api.mapper.VisitMapper;
import com.example.emr_api.repository.PatientRepository;
import com.example.emr_api.repository.VisitRepository;
import com.example.emr_api.service.PatientService;
import com.example.medicoreCommonLib.dto.patient.PatientDetailsDto;
import com.example.medicoreCommonLib.dto.patient.PatientRequestDto;
import com.example.medicoreCommonLib.dto.patient.PatientResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitShortSummaryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Override
    public PatientResponseDto createPatient(PatientRequestDto reqDto) {
        PatientEntity patient = patientMapper.toEntity(reqDto);
        PatientEntity savedPatient = patientRepository.save(patient);
        return patientMapper.toDto(savedPatient);
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        List<PatientEntity> savedPatient = patientRepository.findAll();
        return patientMapper.toDtoList(savedPatient);
    }

    @Override
    public PatientResponseDto getPatientById(Long id) {
        PatientEntity patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PatientEntity not found with id: " + id));
        return patientMapper.toDto(patient);
    }

    @Override
    public PatientDetailsDto getPatientDetailsById(Long id) {
        PatientEntity patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PatientEntity not found with id: " + id));
        List<VisitEntity> visitEntities = visitRepository.findVisitsWithDoctorByPatientId(id);

        List<VisitShortSummaryDto> visitShortSummaryDtos = visitMapper.toShortSummaryDtoList(visitEntities);

        return PatientDetailsDto.builder()
                .patient(patientMapper.toDto(patient))
                .visits(visitShortSummaryDtos)
                .build();
    }

    @Override
    public Map<String, String> deletePatient(Long id) {
        PatientEntity patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PatientEntity not found with id: " + id));
        patientRepository.delete(patient);
        return Map.of("message", "Patient deleted successfully");
    }

    @Override
    public PatientResponseDto getPatientByPesel(String pesel) {
        PatientEntity patient = patientRepository.findByPesel(pesel);
        if(patient != null) return patientMapper.toDto(patient);
        throw new RuntimeException("PatientEntity not found with pesel: " + pesel);
    }

}
