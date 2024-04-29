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
    Trainer trainer = new Trainer("Juan", "Garcia", "juga", "tra145", "2", true, "Fitness");
    Trainee trainee = new Trainee("Juana", "Rodriguez", "lear178", "juro", "1", true,  LocalDate.of(1980, 1, 14),"calle 99 carrera 44");

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
    @Test
    public void testCreateTrainingWithOneNullIds() {
        trainee.setId(null);
        trainer.setId("4");

        Training training = new Training("Running","Agility Training" ,  new Date(), 60, trainee,trainer);
        assertThrows(IllegalArgumentException.class, () -> trainingDao.createTraining(training), "Exception should be thrown when creating training with null IDs");
    }

}