package com.epam.gymapplication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTypeTest {

    private TrainingType trainingType;

    @BeforeEach
    public void setUp() {
        trainingType = new TrainingType("Cardio");
    }

    @Test
    public void testTrainingTypeName() {
        String newTrainingTypeName = "Strength";
        trainingType.setTrainingTypeName(newTrainingTypeName);
        assertEquals(newTrainingTypeName, trainingType.getTrainingTypeName(), "Training type name should be updated to new value");
    }
}