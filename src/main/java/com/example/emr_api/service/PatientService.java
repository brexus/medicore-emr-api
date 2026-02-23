package com.example.emr_api.service;

import com.example.emr_api.dto.patient.PatientRequestDto;
import com.example.emr_api.dto.patient.PatientResponseDto;
import com.example.emr_api.entity.Patient;
import com.example.emr_api.mapper.PatientMapper;
import com.example.emr_api.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientResponseDto createPatient(PatientRequestDto reqDto) {
        Patient patient = patientMapper.toEntity(reqDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDto(savedPatient);
    }

    public List<PatientResponseDto> getAllPatients() {
        List<Patient> savedPatient = patientRepository.findAll();
        return patientMapper.toDtoList(savedPatient);
    }

    public PatientResponseDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        return patientMapper.toDto(patient);
    }

    public Map<String, String> deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        patientRepository.delete(patient);
        return Map.of("message", "Patient deleted successfully");
    }

}
