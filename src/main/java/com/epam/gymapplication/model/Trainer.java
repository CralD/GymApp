package com.epam.gymapplication.model;

public class Trainer extends User{



    private String specialization;

    public Trainer(String firstName, String lastName, String userName, String password, String id, boolean isActive, String specialization) {
        super(firstName, lastName, userName, password, id, isActive);
        this.specialization = specialization;
    }

    public String getSpecialization() {

        return specialization;
    }

    public void setSpecialization(String specialization) {

        this.specialization = specialization;
    }
}
