package com.example.emr_api.service;


import com.example.medicoreCommonLib.dto.patient.PatientDetailsDto;
import com.example.medicoreCommonLib.dto.patient.PatientRequestDto;
import com.example.medicoreCommonLib.dto.patient.PatientResponseDto;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto reqDto);

    Page<PatientResponseDto> getAllPatients(int page, int size);

    PatientResponseDto getPatientById(Long id);

    PatientDetailsDto getPatientDetailsById(Long id);

    Map<String, String> deletePatient(Long id);

    PatientResponseDto getPatientByPesel(String pesel);

}
