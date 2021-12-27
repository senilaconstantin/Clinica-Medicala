package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.model.User;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addNurse")
    public void addNurse(@RequestBody User user) {
        doctorService.addNurse(user);
    }

    @PostMapping("/addRecipe")
    public void addRecipe(@RequestBody Recipe recipe) {
        doctorService.addRecipe(recipe);
    }

    @PutMapping("/updateRecipe/{id}")
    public void updateRecipe(@RequestBody String listOfDrugs, @PathVariable int id) {
        doctorService.updateRecipe(id, listOfDrugs);
    }

    @DeleteMapping("/deletePatient/{username}")
    public void deletePatient(@PathVariable String username) {
        doctorService.deletePatient(username);
    }

    @DeleteMapping("/deleteNurse/{username}")
    public void deleteNurse(@PathVariable String username) {
        doctorService.deleteNurse(username);
    }

    @GetMapping("/showPatients")
    public ArrayList<String> showPatients() {
        return doctorService.showPatients();
    }

    @GetMapping("/showNurses")
    public ArrayList<String> showNurses() {
        return doctorService.showNurses();
    }

    @GetMapping("/notifyDoctor/{username}")
    public ArrayList<String> notifyDoctor(@PathVariable String username) {
        return doctorService.notifyDoctor(username);
    }
}
