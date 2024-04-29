package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TraineeDaoTest {

    private TraineeDao traineeDao;
    private CommonInMemoryStorage storage;
    Trainee trainee = new Trainee("Juan", "Garcia", "tra145", "juga", "1", true, LocalDate.of(1990, 1, 1), "calle 57 carrera 100");


    @BeforeEach
    public void setUp() {
        storage = new CommonInMemoryStorage();
        traineeDao = new TraineeDao(storage);
    }
    @Test
    public void testCreateAndSelectTrainee() {
          traineeDao.createTrainee(trainee);
        assertEquals(trainee, traineeDao.selectTraineeById("1"), "Trainee should be retrieved by ID after being created");
    }
    @Test
    public void testUpdateTrainee() {
        Trainee trainee2 = new Trainee("Juana", "Rodriguez", "lear178", "juro" , "1", true, LocalDate.of(1999, 4, 4), "calle 99 carrera 44");
        traineeDao.createTrainee(trainee);
        traineeDao.updateTrainee(trainee2);
        assertEquals(trainee2, traineeDao.selectTraineeById("1"), "Trainee should be updated to new value");
        assertNotEquals(trainee,traineeDao.selectTraineeById("1"),"Trainee1 should not be equal to traineedDao because was updated");
    }
    @Test
    public void testDeleteTrainee() {
        traineeDao.createTrainee(trainee);
        traineeDao.deleteTrainee(trainee);
        assertNull(traineeDao.selectTraineeById("1"), "Trainee should be null after being deleted");
    }

}