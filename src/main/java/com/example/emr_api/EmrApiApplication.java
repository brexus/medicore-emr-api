package com.example.emr_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.medicalCommonLibrary", "com.example.emr_api"})
@EntityScan(basePackages = {"com.example.medicalCommonLibrary", "com.example.emr_api"})
public class EmrApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmrApiApplication.class, args);
    }

}
