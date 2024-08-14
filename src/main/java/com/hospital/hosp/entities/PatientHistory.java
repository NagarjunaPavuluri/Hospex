package com.hospital.hosp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="patient_history")
public class PatientHistory {


    String patient_id;
    String patient_name;
    String treated_doctor;
    @Id
    Date treated_date;

    Double amount_paid;

}
