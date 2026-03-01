package com.example.emr_api.service;

import com.example.medicoreCommonLib.dto.doctor.DoctorResponseDto;

import java.util.List;

public interface DoctorService {
    List<DoctorResponseDto> serachDoctor(String query);

}
