package com.hospital.hosp.service;

import com.hospital.hosp.entities.Doctor;
import com.hospital.hosp.entities.DoctorDetails;
import com.hospital.hosp.repository.DoctorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
public class DoctorServiceImpl implements DoctorService{


    @Autowired
    DoctorDetailsRepo doctorDetailsRepo;


    DoctorDetails doctorDetails=new DoctorDetails();
    @Override
    public String addDoctor(Doctor doctor) {

        String docId="AA";
        Random r=new Random();
        int num= r.nextInt(100,1000)+1;
        docId=docId+num;
        while (doctorDetailsRepo.existsById(docId)){
            docId="AA";
            num= r.nextInt(100,1000)+1;
            docId=docId+num;
        }
        doctorDetails.setDoctor_id(docId);
        doctorDetails.setEmail(doctor.getEmail());
        doctorDetails.setQualification(doctor.getQualification());
        doctorDetails.setDoctorName(doctor.getDoctor_name());
        doctorDetails.setSpecialist(doctor.getSpecialist());
        doctorDetails.setPhone_number(doctor.getPhone_number());
        doctorDetailsRepo.save(doctorDetails);
        return "Added Doctor details and Doctor Id is "+docId+".";
    }

    @Override
    public Optional<DoctorDetails> getDoctorDetails(String id) {
        Optional<DoctorDetails> details=doctorDetailsRepo.findById(id);
        return details;
    }

   /* @Override
    public String UpdateDoctor(Doctor doctor) {
        doctorDetailsRepo.saveAll()
        return null;
    }*/

    @Override
    public String DeleteDoctor(String id) {
        if(doctorDetailsRepo.existsById(id)){
            doctorDetailsRepo.deleteById(id);
        }else{
            return "No Doctor found with "+id+". Please check the details";
        }
        return "Doctor with id "+id+" deleted successfully";
    }
}
