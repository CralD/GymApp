package com.epam.gymapplication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    private Trainer trainer;
    @BeforeEach
    public void setUp() {
        trainer = new Trainer("Ana", "Arteaga", "Anar", "123456789a", "1", true, "Strength" );
    }
    @Test
    public void createTrainerIsWorking(){




        assertEquals("Ana", trainer.getFirstName(), "First name should match");
        assertEquals("Arteaga", trainer.getLastName(), "Last name should match");
        assertEquals("123456789a", trainer.getPassword(), "Password should match");
        assertEquals("Anar", trainer.getUserName(), "Username should match");
        assertEquals("1", trainer.getId(), "ID should match");
        assertEquals(true, trainer.isActive(), "Active status should match");
        assertEquals("Strength",trainer.getSpecialization(), "Date of Birth should match");

    }
    @Test
    public void testSetUsermethods(){
        trainer.setFirstName("Raul");
        trainer.setLastName("Perez");
        trainer.setUserName("RauPer13");
        trainer.setId("4");
        trainer.setActive(false);
        trainer.setPassword("ra5533pe00");

        assertEquals("Raul", trainer.getFirstName(), "First name should match");
        assertEquals("Perez", trainer.getLastName(), "Last name should match");
        assertEquals("ra5533pe00", trainer.getPassword(), "Password should match");
        assertEquals("RauPer13", trainer.getUserName(), "Username should match");
        assertEquals("4", trainer.getId(), "ID should match");
        assertEquals(false, trainer.isActive(), "Active status should match");

    }

    @Test
    public void testSetEspecializationIsWorking(){
        String newSpecialization = "Agility";
        trainer.setSpecialization(newSpecialization);
        assertEquals("Agility",trainer.getSpecialization(),"Should match");
    }

}