package com.hospital.hosp.repository;

import com.hospital.hosp.entities.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepo extends JpaRepository<PatientDetails,String> {
    public PatientDetails findByPatientName(String name);
}
