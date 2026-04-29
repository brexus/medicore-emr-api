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
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
@AllArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/today")
    public ResponseEntity<Page<VisitBasicResponseDto>> getTodayVisits(
            @AuthenticationPrincipal Jwt jwt,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<VisitBasicResponseDto> resPage = visitService.getTodayVisits(jwt.getSubject(), page, size);
        return ResponseEntity.status(HttpStatus.OK).body(resPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitResponseDto> getVisitById(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        VisitResponseDto resDto = visitService.getVisitByIdForDoctorId(id, jwt.getSubject());
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping
    public ResponseEntity<VisitResponseDto> createVisit(@Valid @RequestBody VisitRequestDto reqDto, @AuthenticationPrincipal Jwt jwt) {
        VisitResponseDto resDto = visitService.createVisit(reqDto, jwt.getSubject());
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
