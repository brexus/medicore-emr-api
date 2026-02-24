package com.example.emr_api.mapper;

import com.example.emr_api.entity.Address;
import com.example.medicoreCommonLib.dto.address.AddressRequestDto;
import com.example.medicoreCommonLib.dto.address.AddressResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AddressMapper {

    Address toEntity(AddressRequestDto dto);

    AddressResponseDto toDto(Address entity);
}