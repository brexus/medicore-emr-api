package com.example.emr_api.mapper;

import com.example.emr_api.entity.VisitEntity;
import com.example.medicoreCommonLib.dto.visit.VisitBasicResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitRequestDto;
import com.example.medicoreCommonLib.dto.visit.VisitResponseDto;
import com.example.medicoreCommonLib.dto.visit.VisitShortSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface VisitMapper {
    VisitEntity toEntity(VisitRequestDto dto);

    VisitResponseDto toDto(VisitEntity entity);

    List<VisitResponseDto> toDtoList(List<VisitEntity> visitEntities);

    VisitBasicResponseDto toBasicDto(VisitEntity entity);

    List<VisitBasicResponseDto> toBasicDtoList(List<VisitEntity> visitEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "visitDate", source = "visitDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "doctorFullName", expression = "java(visit.getDoctor().getFirstName() + \" \" + visit.getDoctor().getLastName())")
    VisitShortSummaryDto toShortSummaryDto(VisitEntity visit);

    List<VisitShortSummaryDto> toShortSummaryDtoList(List<VisitEntity> visits);
}