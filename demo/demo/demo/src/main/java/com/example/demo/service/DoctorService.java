package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void addPatient(User user) {
        doctorRepository.addPatient(user);
    }

    public void addRecipe(Recipe recipe) {
        doctorRepository.addRecipe(recipe);
    }

    public void updateRecipe(int id, String listOfDrugs) {
        doctorRepository.updateRecipe(id, listOfDrugs);
    }

    public void deletePatient(String username) {
        doctorRepository.deletePatient(username);
    }

    public ArrayList<String> showPatients() {
        ResultSet rs = doctorRepository.showPatients();
        ArrayList<String> showP = new ArrayList<>();
        try {
            while (rs.next()) {

                String id = rs.getString("id");
                String nume = rs.getString("firstName");
                String prenume = rs.getString("lastName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String phoneNumber = rs.getString("phoneNumber");


                String s = id + "  " + nume + " " + prenume + " " + username+" "+ password + " " + role + " " + phoneNumber;
                showP.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showP;
    }

    public ArrayList<String> showNurses() {
        ResultSet rs = doctorRepository.showNurses();
        ArrayList<String> showN = new ArrayList<>();
        try {
            while (rs.next()) {

                String id = rs.getString("id");
                String nume = rs.getString("firstName");
                String prenume = rs.getString("lastName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String phoneNumber = rs.getString("phoneNumber");

                String s = id + "  " + nume + " " + prenume + " " + username+" "+ password + " " + role + " " + phoneNumber;
                showN.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showN;
    }
}
