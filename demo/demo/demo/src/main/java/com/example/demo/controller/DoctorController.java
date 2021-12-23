package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/addPatient")
    public void addPatient(@RequestBody User user) {
        doctorService.addPatient(user);
    }

    @PostMapping("/addRecipe")
    public void addRecipe(@RequestBody Recipe recipe) {
        doctorService.addRecipe(recipe);
    }

    @PutMapping("/updateRecipe")
    public void updateRecipe(@RequestBody String usernamePatient, String listOfDrugs) {
        doctorService.updateRecipe(usernamePatient, listOfDrugs);
    }

    @DeleteMapping("/deletePatient/{id}")
    public void deletePatient(@PathVariable String username) {
        doctorService.deletePatient(username);
    }

    @GetMapping("/showPatients")
    public ArrayList<String> showPatients() {
        return doctorService.showPatients();
    }

    @GetMapping("/showNurses")
    public ArrayList<String> showNurses()  {
        return doctorService.showNurses();
    }
}
