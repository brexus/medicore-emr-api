package com.example.emr_api.controller;

import com.example.emr_api.repository.MedicalRecordRepository;
import com.example.emr_api.service.MedicalRecordService;
import com.example.emr_api.service.VisitService;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-record")
@AllArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordService medicalRecordService;


    @PatchMapping("/{id}")
    public ResponseEntity<VisitResponseDto> updateVisitById(@Valid @RequestBody VisitRequestDto reqDto, @PathVariable Long id) {
//        VisitResponseDto resDto = medicalRecordService.create(id);
//        return ResponseEntity.status(HttpStatus.OK).body(resDto);
        return null;
    }
}
