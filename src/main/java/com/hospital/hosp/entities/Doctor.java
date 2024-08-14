package com.hospital.hosp.entities;

import lombok.Data;

@Data
public class Doctor {

    String doctor_name;
    String qualification;
    long phone_number;
    String email;
    String specialist;
}
