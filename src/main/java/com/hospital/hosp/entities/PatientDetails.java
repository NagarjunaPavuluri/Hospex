package com.hospital.hosp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="patient_details")

public class PatientDetails {

    @Id
    String patient_id;
    @Column(name="patient_name")
    String patientName;
    long phone_number;
    String treated_doctor_name;

    Date treatedDate;
}
