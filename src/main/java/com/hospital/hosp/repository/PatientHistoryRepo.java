package com.hospital.hosp.repository;

import com.hospital.hosp.entities.PatientHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PatientHistoryRepo extends JpaRepository<PatientHistory, Date> {
}
