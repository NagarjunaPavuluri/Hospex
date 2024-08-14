package com.hospital.hosp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_details")
public class DoctorDetails {

    @Id
    String doctor_id;
    @Column(name = "doctor_name")
    String doctorName;
    String qualification;
    long phone_number;
    String email;
    String specialist;

}
