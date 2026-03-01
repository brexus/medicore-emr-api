package com.example.emr_api.controller;

import com.example.emr_api.service.PatientService;
import com.example.medicoreCommonLib.dto.patient.PatientDetailsDto;
import com.example.medicoreCommonLib.dto.patient.PatientRequestDto;
import com.example.medicoreCommonLib.dto.patient.PatientResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto reqDto) {
        PatientResponseDto resDto = patientService.createPatient(reqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resDto);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
        List<PatientResponseDto> resDto = patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<PatientDetailsDto> getPatientDetailsById(@PathVariable Long id) {
        PatientDetailsDto resDto = patientService.getPatientDetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id) {
        PatientResponseDto resDto = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePatient(@PathVariable Long id) {
        Map<String, String> res = patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/pesel/{pesel}")
    public ResponseEntity<PatientResponseDto> getPatientByPesel(@PathVariable String pesel) {
        PatientResponseDto resDto = patientService.getPatientByPesel(pesel);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

}
