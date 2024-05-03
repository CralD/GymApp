package com.epam.gymapplication.model;

import java.time.LocalDate;


    public class Trainee extends User {

        private LocalDate DateOfBirth;
        private String Address;

        public Trainee(String firstName,String lastName,String password, String userName,Long id,boolean isActive,LocalDate dateOfBirth, String address) {
            super(firstName,lastName,userName,password,id,isActive);
            DateOfBirth = dateOfBirth;
            Address = address;
        }

        public LocalDate getDateOfBirth() {
            return DateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            DateOfBirth = dateOfBirth;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }
    }

