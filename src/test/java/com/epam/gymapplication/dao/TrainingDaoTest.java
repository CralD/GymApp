package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TrainingDaoTest {
    private TrainingDao trainingDao;
    private CommonInMemoryStorage storage;
    Trainer trainer = new Trainer("John", "Doe", "password", "jdoe", "1", true, "Fitness");
    Trainee trainee = new Trainee("Jane", "Doe", "password", "jdoe", "1", true,  LocalDate.of(1990, 1, 1),"123 Street");

    @BeforeEach
    public void setUp() {
        storage = new CommonInMemoryStorage();
        trainingDao = new TrainingDao(storage);

    }


    @Test
    public void testCreateAndSelectTraining() {
        Training training = new Training("Running", "Agility Training", new Date(), 60, trainee,trainer);
        trainingDao.createTraining(training);
        assertEquals(training, trainingDao.selectTraining("1"), "Training should be retrieved by ID after being created");
    }

    @Test
    public void testCreateTrainingWithNullIds() {
        trainee.setId(null);
        trainer.setId(null);

        Training training = new Training("Running","Agility Training" ,  new Date(), 60, trainee,trainer);
        assertThrows(IllegalArgumentException.class, () -> trainingDao.createTraining(training), "Exception should be thrown when creating training with null IDs");
    }

}