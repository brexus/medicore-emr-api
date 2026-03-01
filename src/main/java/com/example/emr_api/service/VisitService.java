package com.example.emr_api.service;

import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordRequestDto;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitBasicResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import com.example.medicoreCommonLib.enums.VisitStatusEnum;

import java.util.List;
import java.util.Map;

public interface VisitService {
    List<VisitBasicResponseDto> getTodayVisits();

    VisitResponseDto getVisitById(Long id);

    VisitResponseDto createVisit(VisitRequestDto reqDto);

    MedicalRecordResponseDto upsertMedicalRecord(MedicalRecordRequestDto reqDto);

    MedicalRecordResponseDto getMedicalRecordByVisitId(Long visitId);

    Void changeVisitStatus(Long visitId, VisitStatusEnum status);
}
