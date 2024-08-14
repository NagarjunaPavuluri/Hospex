package com.hospital.hosp.service;

import com.hospital.hosp.entities.Doctor;
import com.hospital.hosp.entities.DoctorDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DoctorService {
    public String addDoctor(Doctor doctor);
    public Optional<DoctorDetails> getDoctorDetails(String id);
   // public String UpdateDoctor(String id,String field,);
    public String DeleteDoctor(String id);
}
