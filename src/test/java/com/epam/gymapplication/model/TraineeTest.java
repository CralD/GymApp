package com.epam.gymapplication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {
    private Trainee trainee;

    @BeforeEach
    public void setUp() {
        trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", "1", true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
    }

    @Test
    public void testCreateTrainee(){
        Trainee trainee = new Trainee("pedro", "Hernandez", "b455q99", "peju", "1", true, LocalDate.of(1975, 6, 22), "carrera 22 calle 22");

        assertEquals("pedro", trainee.getFirstName(), "First name should match");
        assertEquals("Hernandez", trainee.getLastName(), "Last name should match");
        assertEquals("b455q99", trainee.getPassword(), "Username should match");
        assertEquals("peju", trainee.getUserName(), "Password should match");
        assertEquals("1", trainee.getId(), "ID should match");
        assertEquals(true, trainee.isActive(), "Active status should match");
        assertEquals(LocalDate.of(1975, 6, 22), trainee.getDateOfBirth(), "Date of Birth should match");
        assertEquals("carrera 22 calle 22", trainee.getAddress(), "Address should match");
    }
    @Test
    public void testCreateTwoTrainees() {


        Trainee trainee2 = new Trainee("pedro", "juan", "b455q99", "peju", "2", false, LocalDate.of(1975, 6, 22), "carrera 22 calle 22");

        assertNotEquals(trainee2.getFirstName(), trainee.getFirstName(), "First name should not match");
        assertNotEquals(trainee2.getLastName(), trainee.getLastName(), "Last name should not  match");
        assertNotEquals(trainee2.getUserName(), trainee.getUserName(), "Username should not match");
        assertNotEquals(trainee2.getPassword(), trainee.getPassword(), "Password should not match");
        assertNotEquals(trainee2.getId(), trainee.getId(), "ID should not match");
        assertNotEquals(trainee2.isActive(), trainee.isActive(), "Active status should not match");
        assertNotEquals(trainee2.getDateOfBirth(), trainee.getDateOfBirth(), "Date of Birth should not match");
        assertNotEquals(trainee2.getAddress(), trainee.getAddress(), "Address should not match");

    }

    @Test
    public void testDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.of(1991, 1, 1);
        trainee.setDateOfBirth(newDateOfBirth);
        assertEquals(newDateOfBirth, trainee.getDateOfBirth(), "Date of Birth should be updated to new value");
    }

    @Test
    public void testAddress() {
        String newAddress = "456 Avenue";
        trainee.setAddress(newAddress);
        assertEquals(newAddress, trainee.getAddress(), "Address should be updated to new value");
    }
}