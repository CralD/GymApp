package com.epam.gymapplication.dao;
import com.epam.gymapplication.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerDaoTest {
    private TrainerDao trainerDao;
    private CommonInMemoryStorage storage;
    Trainer trainer = new Trainer("John", "Doe", "password", "jdoe", "1", true, "Fitness");
    Trainer trainer2 = new Trainer("Jane", "Doe", "password", "jdoe", "1", true, "Yoga");

    @BeforeEach
    public void setUp() {
        storage = new CommonInMemoryStorage();
        trainerDao = new TrainerDao(storage);

    }

    @Test
    public void testCreateAndSelectTrainer() {

        trainerDao.createTrainer(trainer);
        assertEquals(trainer, trainerDao.selectTrainerById("1"), "Trainer should be retrieved by ID after being created");
    }

    @Test
    public void testUpdateTrainer() {


        trainerDao.createTrainer(trainer);
        trainerDao.updateTrainer(trainer2);
        assertEquals(trainer2, trainerDao.selectTrainerById("1"), "Trainer should be updated to new value");
    }

}