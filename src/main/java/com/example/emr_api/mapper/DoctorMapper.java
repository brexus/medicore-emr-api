package com.example.emr_api.mapper;

import com.example.emr_api.entity.DoctorEntity;
import com.example.medicoreCommonLib.dto.doctor.DoctorRequestDto;
import com.example.medicoreCommonLib.dto.doctor.DoctorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class}, unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface DoctorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DoctorEntity toEntity(DoctorRequestDto reqDto);

    DoctorResponseDto toDto(DoctorEntity doctor);

    List<DoctorResponseDto> toDtoList(List<DoctorEntity> doctorEntities);
}
