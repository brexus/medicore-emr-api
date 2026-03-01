package com.example.emr_api.service;


import com.example.medicoreCommonLib.dto.patient.PatientDetailsDto;
import com.example.medicoreCommonLib.dto.patient.PatientRequestDto;
import com.example.medicoreCommonLib.dto.patient.PatientResponseDto;

import java.util.List;
import java.util.Map;

public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto reqDto);

    List<PatientResponseDto> getAllPatients();

    PatientResponseDto getPatientById(Long id);

    PatientDetailsDto getPatientDetailsById(Long id);

    Map<String, String> deletePatient(Long id);

    PatientResponseDto getPatientByPesel(String pesel);

}
