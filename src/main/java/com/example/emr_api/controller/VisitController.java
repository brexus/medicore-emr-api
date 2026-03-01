package com.example.emr_api.controller;

import com.example.emr_api.service.VisitService;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordRequestDto;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitBasicResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import com.example.medicoreCommonLib.enums.VisitStatusEnum;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
@AllArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/today")
    public ResponseEntity<List<VisitBasicResponseDto>> getTodayVisits() {
        List<VisitBasicResponseDto> resDtosList = visitService.getTodayVisits();
        return ResponseEntity.status(HttpStatus.OK).body(resDtosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitResponseDto> getVisitById(@PathVariable Long id) {
        VisitResponseDto resDto = visitService.getVisitById(id);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }


    @PostMapping
    public ResponseEntity<VisitResponseDto> createVisit(@Valid @RequestBody VisitRequestDto reqDto) {
        VisitResponseDto resDto = visitService.createVisit(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @PutMapping("/medical-record")
    public ResponseEntity<MedicalRecordResponseDto> upsertMedicalRecord(@Valid @RequestBody MedicalRecordRequestDto reqDto) {
        MedicalRecordResponseDto resDto = visitService.upsertMedicalRecord(reqDto);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @PatchMapping("/{visitId}/status")
    public ResponseEntity<Void> changeVisitStatus(@PathVariable Long visitId, @RequestParam VisitStatusEnum status) {
        visitService.changeVisitStatus(visitId, status);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
