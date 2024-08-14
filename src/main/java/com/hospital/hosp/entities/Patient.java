package com.hospital.hosp.entities;

import lombok.Data;

@Data
public class Patient {

    String patient_name;
    long phone_number;
    String treated_doctor_name;

}
