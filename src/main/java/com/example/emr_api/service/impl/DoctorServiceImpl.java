package com.example.emr_api.service.impl;

import com.example.emr_api.entity.DoctorEntity;
import com.example.emr_api.mapper.DoctorMapper;
import com.example.emr_api.repository.DoctorRepository;
import com.example.emr_api.service.DoctorService;
import com.example.medicoreCommonLib.dto.doctor.DoctorResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponseDto> searchDoctor(String query) {
        List<DoctorEntity> doctorsEntities = doctorRepository.searchDoctorsByFirstNameAndLastName(query);

        return doctorMapper.toDtoList(doctorsEntities);
    }
}
