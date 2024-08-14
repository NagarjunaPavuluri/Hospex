package com.hospital.hosp.service;

import com.hospital.hosp.entities.Patient;
import com.hospital.hosp.entities.PatientDetails;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public PatientDetails addPatient(Patient patient);
    //public String updatePatient(Patient patient);

    public Optional<PatientDetails> getPatientDetails(String id);

    public List<PatientDetails> getHistory(String id);
}
