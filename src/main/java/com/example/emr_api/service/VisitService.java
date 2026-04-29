package com.example.emr_api.service;

import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordRequestDto;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitBasicResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import com.example.medicoreCommonLib.enums.VisitStatusEnum;
import org.springframework.data.domain.Page;

public interface VisitService {
    Page<VisitBasicResponseDto> getTodayVisits(String doctorKeycloakId, int page, int size);

    VisitResponseDto getVisitByIdForDoctorId(Long visitId, String doctorKeycloakId);

    VisitResponseDto createVisit(VisitRequestDto reqDto, String doctorKeycloakId);

    MedicalRecordResponseDto upsertMedicalRecord(MedicalRecordRequestDto reqDto);

    MedicalRecordResponseDto getMedicalRecordByVisitId(Long visitId);

    Void changeVisitStatus(Long visitId, VisitStatusEnum status);
}
