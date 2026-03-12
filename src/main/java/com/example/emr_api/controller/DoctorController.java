package com.example.emr_api.controller;

import com.example.emr_api.entity.DoctorEntity;
import com.example.emr_api.service.DoctorService;
import com.example.medicoreCommonLib.dto.doctor.DoctorResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;


    @GetMapping("/search")
    public ResponseEntity<List<DoctorResponseDto>> searchDoctor(@RequestParam("query") String query) {
        List<DoctorResponseDto> doctorsRes = doctorService.searchDoctor(query);
        return ResponseEntity.status(HttpStatus.OK).body(doctorsRes);
    }

}
