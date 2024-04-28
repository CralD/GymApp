package com.epam.gymapplication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {
    private Training training;

    @BeforeEach
    public void setUp() {
        // Create a Trainee and a Trainer for the Training
        Trainee trainee = new Trainee("pedro", "Hernandez", "b455q99", "peju", "1", true, LocalDate.of(1975, 6, 22), "carrera 22 calle 22");
        Trainer trainer = new Trainer("Ana", "Arteaga", "Anar", "123456789a", "2", true, "Strength");

        // Create a Training object
        String trainingName = "Weightlifting";
        String trainingType = "Strength Training";
        Date trainingDate = new Date(2024, 06, 24);
        int trainingDuration = 60; // in minutes

        training = new Training(trainingName, trainingType, trainingDate, trainingDuration, trainee, trainer);
    }

    @Test
    public void createTrainingIsWorking(){


        assertEquals("Weightlifting",training.getTrainingName(),"Name should match");
        assertEquals("Strength Training",training.getTrainingType(),"Type should match");
        assertEquals(new Date(2024,06,24),training.getTrainingDate(),"Date should match");
        assertEquals(60,training.getTrainingDuration(),"Duration should match");
        assertEquals("1",training.getTraineeId(),"Trainee id should match");
        assertEquals("2",training.getTrainerId(),"Trainer id should match");

    }
    @Test
    public void setMethodsAreWorking(){

        training.setTrainingDate(new Date(2024,7,28));
        training.setTrainee(training.getTraineeId());
        training.setTrainer(training.getTrainerId());
        training.setTrainingDuration(80);
        training.setTrainingName("Running");
        training.setTrainingType("Agility Training");
        assertEquals("Running",training.getTrainingName(),"Name should match");
        assertEquals("Agility Training",training.getTrainingType(),"Type should match");
        assertEquals(new Date(2024,07,28),training.getTrainingDate(),"Date should match");
        assertEquals(80,training.getTrainingDuration(),"Duration should match");
        assertEquals("1",training.getTraineeId(),"Trainee id should match");
        assertEquals("2",training.getTrainerId(),"Trainer id should match");

    }

}