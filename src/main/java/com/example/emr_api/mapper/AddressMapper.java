package com.example.emr_api.mapper;

import com.example.emr_api.entity.AddressEntity;
import com.example.medicoreCommonLib.dto.address.AddressRequestDto;
import com.example.medicoreCommonLib.dto.address.AddressResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressEntity toEntity(AddressRequestDto dto);

    AddressResponseDto toDto(AddressEntity entity);
}