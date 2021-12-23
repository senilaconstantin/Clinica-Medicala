package com.example.demo.model;

import java.util.Date;


public class Appointment {

    private int id;
    private String usernameDoctor;
    private String usernamePatient;
    private Date date;

    public Appointment(int id, String usernamePatient, String usernameDoctor, Date date) {
        this.id = id;
        this.usernameDoctor = usernameDoctor;
        this.usernamePatient = usernamePatient;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernameDoctor() {
        return usernameDoctor;
    }

    public void setUsernameDoctor(String usernameDoctor) {
        this.usernameDoctor = usernameDoctor;
    }

    public String getUsernamePatient() {
        return usernamePatient;
    }

    public void setUsernamePatient(String usernamePatient) {
        this.usernamePatient = usernamePatient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", usernameDoctor='" + usernameDoctor + '\'' +
                ", usernamePatient='" + usernamePatient + '\'' +
                ", date=" + date +
                '}';
    }
}
