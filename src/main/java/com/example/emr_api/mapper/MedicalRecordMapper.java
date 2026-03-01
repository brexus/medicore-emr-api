package com.example.emr_api.mapper;

import com.example.emr_api.entity.MedicalRecordEntity;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordRequestDto;
import com.example.medicoreCommonLib.dto.medicalRecord.MedicalRecordResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface MedicalRecordMapper {
//    @Mapping(source = "visit.id", target = "visitId")
    MedicalRecordResponseDto toDto(MedicalRecordEntity medicalRecordEntity);

    List<MedicalRecordResponseDto> toDtoList(List<MedicalRecordEntity> visitList);

//    @Mapping(target = "visit", ignore = true)
    MedicalRecordEntity toEntity(MedicalRecordRequestDto visitRequestDto);
}