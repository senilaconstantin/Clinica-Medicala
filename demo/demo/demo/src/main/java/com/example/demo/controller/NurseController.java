package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @PostMapping("/addPatient")
    public void addPatient(@RequestBody User user) {
        nurseService.addPatient(user);
    }

    @DeleteMapping("/deletePatient/{username}")
    public void deletePatient(@PathVariable String username) {
        nurseService.deletePatient(username);
    }

    @GetMapping("/showPatients")
    public ArrayList<String> showPatients() {
        return nurseService.showPatients();
    }

}
