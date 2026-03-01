package com.example.emr_api.service.impl;

import com.example.emr_api.mapper.MedicalRecordMapper;
import com.example.emr_api.repository.MedicalRecordRepository;
import com.example.emr_api.service.MedicalRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalRecordMapper medicalRecordMapper;


}
