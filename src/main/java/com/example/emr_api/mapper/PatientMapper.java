package com.example.emr_api.mapper;

import com.example.emr_api.entity.Patient;
import com.example.medicoreCommonLib.dto.patient.PatientRequestDto;
import com.example.medicoreCommonLib.dto.patient.PatientResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PatientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Patient toEntity(PatientRequestDto reqDto);

    PatientResponseDto toDto(Patient customer);

    List<PatientResponseDto> toDtoList(List<Patient> patients);
}
