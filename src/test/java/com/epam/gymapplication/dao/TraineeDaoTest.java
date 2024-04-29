package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TraineeDaoTest {

    private TraineeDao traineeDao;
    private CommonInMemoryStorage storage;

    @BeforeEach
    public void setUp() {
        storage = new CommonInMemoryStorage();
        traineeDao = new TraineeDao(storage);
    }
    @Test
    public void testCreateAndSelectTrainee() {
        Trainee trainee = new Trainee("John", "Doe", "password", "jdoe", "1", true, LocalDate.of(1990, 1, 1), "123 Street");
        traineeDao.createTrainee(trainee);
        assertEquals(trainee, traineeDao.selectTraineeById("1"), "Trainee should be retrieved by ID after being created");
    }
    @Test
    public void testUpdateTrainee() {
        Trainee trainee1 = new Trainee("John", "Doe", "password", "jdoe", "1", true, LocalDate.of(1990, 1, 1), "123 Street");
        Trainee trainee2 = new Trainee("Jane", "Doe", "password", "jdoe", "1", true, LocalDate.of(1990, 1, 1), "123 Street");
        traineeDao.createTrainee(trainee1);
        traineeDao.updateTrainee(trainee2);
        assertEquals(trainee2, traineeDao.selectTraineeById("1"), "Trainee should be updated to new value");
        assertNotEquals(trainee1,traineeDao.selectTraineeById("1"),"Trainee1 should not be equal to traineedDao because was updated");
    }
    @Test
    public void testDeleteTrainee() {
        Trainee trainee = new Trainee("John", "Doe", "password", "jdoe", "1", true, LocalDate.of(1990, 1, 1), "123 Street");
        traineeDao.createTrainee(trainee);
        traineeDao.deleteTrainee(trainee);
        assertNull(traineeDao.selectTraineeById("1"), "Trainee should be null after being deleted");
    }

}