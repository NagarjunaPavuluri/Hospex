package com.hospital.hosp.service;

import com.hospital.hosp.entities.DoctorDetails;
import com.hospital.hosp.entities.Patient;
import com.hospital.hosp.entities.PatientDetails;
import com.hospital.hosp.entities.PatientHistory;
import com.hospital.hosp.repository.DoctorDetailsRepo;
import com.hospital.hosp.repository.PatientDetailsRepo;
import com.hospital.hosp.repository.PatientHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PatientServiceImpl implements PatientService{
    PatientDetails patientDetails=new PatientDetails();
    @Autowired
    PatientDetailsRepo patientDetailsRepo;
    @Autowired
    DoctorDetailsRepo doctorDetailsRepo;
    @Autowired
    PatientHistoryRepo patientHistoryRepo;
    @Autowired
    private KafkaProducer producer;





    @Override
    public PatientDetails addPatient(Patient patient) {
        PatientHistory patientHistory=new PatientHistory();
        PatientDetails pdetails=patientDetailsRepo.findByPatientName(patient.getPatient_name());

        Random r=new Random();
        if(pdetails!=null){
            patientHistory.setPatient_id(pdetails.getPatient_id());
            patientHistory.setPatient_name(pdetails.getPatientName());
            patientHistory.setAmount_paid(r.nextDouble(1000,100000));
            if(checkDoc(patient)){
                patientHistory.setTreated_doctor(patient.getTreated_doctor_name());
            }else{
                throw new RuntimeException("Doctor Does not exist");
            }

            patientHistory.setTreated_date(Date.from(Instant.now()));

            patientHistoryRepo.save(patientHistory);
            return pdetails;
        }
        else{
            String id;
            int num= r.nextInt(100,1000)+2;
            id="PP"+num;
            while (patientDetailsRepo.existsById(id)){
                num= r.nextInt(100,1000)+2;
                id="PP"+num;
            }
            patientDetails.setPatient_id(id);
            patientDetails.setPatientName(patient.getPatient_name());
            if(!checkMobileNum(patient)){
                throw new RuntimeException("please check the Mobile Number");
            }
            else{
                patientDetails.setPhone_number(patient.getPhone_number());
            }

            patientDetails.setTreatedDate(Date.from(Instant.now()));


            if(checkDoc(patient)){
                patientDetails.setTreated_doctor_name(patient.getTreated_doctor_name());
            }else {
                throw new RuntimeException("Doctor does not exist");
            }
            patientDetailsRepo.save(patientDetails);
           producer.produce(patientDetails);
            return patientDetails;
        }

    }

    public boolean checkMobileNum(Patient patient){

        if(String.valueOf(patient.getPhone_number()).length()!=10){
            return false;
        }
        else return true;
    }

    public boolean checkDoc(Patient patient){
        DoctorDetails doctorDetails=doctorDetailsRepo.findByDoctorName(patient.getTreated_doctor_name());
        if(doctorDetails!=null){
            return true;
        }
        return false;
    }


    @Override
    public Optional<PatientDetails> getPatientDetails(String id) {
        Optional<PatientDetails> patientDetails1=patientDetailsRepo.findById(id);
        return patientDetails1;
    }

    @Override
    public List<PatientDetails> getHistory(String id) {
        return null;
    }
}
