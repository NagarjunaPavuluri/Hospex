package com.hospital.hosp.repository;

import com.hospital.hosp.entities.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailsRepo extends JpaRepository<DoctorDetails,String> {

    public DoctorDetails findByDoctorName(String doctor_name);
}
