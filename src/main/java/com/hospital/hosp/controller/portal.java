package com.hospital.hosp.controller;

import com.hospital.hosp.entities.Doctor;
import com.hospital.hosp.entities.DoctorDetails;
import com.hospital.hosp.entities.Patient;
import com.hospital.hosp.entities.PatientDetails;
import com.hospital.hosp.service.DoctorServiceImpl;
import com.hospital.hosp.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/AA")
public class portal {
    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    PatientServiceImpl patientService;

    @GetMapping("/")
    public String index() {
        return "index"; // Refers to index.html in the templates folder
    }
    @GetMapping("/getDoc/{id}")
    public ResponseEntity<Optional<DoctorDetails>>getDoctor(@PathVariable String id){
        Optional<DoctorDetails>d=doctorService.getDoctorDetails(id);

        return ResponseEntity.ok(d);
    }
    @PostMapping("/adddoc")
    public ResponseEntity<String>adddoc(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
        return ResponseEntity.ok("Doctor details added successfully");
    }
    @GetMapping("/delDoc/{id}")
    public String deleteDoctor(@PathVariable String id){
        Optional<DoctorDetails>d=doctorService.getDoctorDetails(id);
        doctorService.DeleteDoctor(id);

        return "Doctor With "+d.get().getDoctor_id()+" deleted Successfully ";
    }

    @PostMapping("/addP")
    public ResponseEntity<PatientDetails> addP(@RequestBody Patient patient){
        PatientDetails patientDetails=patientService.addPatient(patient);
        return ResponseEntity.ok(patientDetails);

    }
    @GetMapping("/gP/{id}")
    public ResponseEntity<Optional<PatientDetails>> getP(@PathVariable String id){
        Optional<PatientDetails> patientDetails=patientService.getPatientDetails(id);
        return ResponseEntity.ok(patientDetails);

    }


}
