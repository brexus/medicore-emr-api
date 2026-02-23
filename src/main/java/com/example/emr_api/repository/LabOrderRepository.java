package com.example.emr_api.repository;

import com.example.emr_api.entity.LabOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabOrderRepository extends JpaRepository<LabOrder, Long> {

}
