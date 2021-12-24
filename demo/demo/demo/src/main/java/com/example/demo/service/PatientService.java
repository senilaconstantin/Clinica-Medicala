package com.example.demo.service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.NurseRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
//    public ResultSet showRecipe(String usernamePatient, String usernameDoctor) {
//
//    }
    public void addAppointment(Appointment appointment) {
        patientRepository.addAppointment(appointment);
    }
//    public ResultSet showDetails(String userName, String password) {
//        patientRepository.showDetails(userName);
//    }
}
