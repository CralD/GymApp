package com.epam.gymapplication.dao;
import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class TrainerDaoTest {
    @Mock
    private CommonInMemoryStorage storageMock;

    @InjectMocks
    private TrainerDao trainerDao;

    private Map<Long, Trainer> trainers;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        trainers = new HashMap<>();
        trainers.put(1L,new Trainer("Ana", "Arteaga", "123456789a", "Anar", 1L, true,  "Fitness")) ;
        when(storageMock.getTrainers()).thenReturn(trainers);
        trainerDao = new TrainerDao(storageMock);
    }

    @Test
    public void getById_existingTrainer_shouldReturnTrainer() {
        Trainer trainer = trainerDao.getById(1L);
        assertEquals("Ana", trainer.getFirstName());
    }
    @Test
    void getById_nonExistingTrainee_shouldReturnNull() {
        Trainer trainer = trainerDao.getById(100L);
        assertEquals(null, trainer);
    }

    @Test
    public void save_newTrainer_shouldAddTrainer() {
        Trainer newTrainer = new Trainer("Juan", "Naranjas", "12384565789b", "Juna", 2L, false, "Yoga");
        trainerDao.save(2L, newTrainer);
        assertEquals(newTrainer, trainerDao.getById(2L));
    }

    @Test
    public void update_existingTrainer_shouldUpdateTrainer() {
        Trainer updatedTrainer = new Trainer("Juan", "Arteaga", "12384565789b", "Juar", 2L, true, "Pilates");
        trainerDao.update(1L, updatedTrainer);
        assertEquals(updatedTrainer, trainerDao.getById(1L));
    }
    @Test
    void update_nonExistingTrainer_shouldNotUpdate() {
        Trainer updatedTrainer = new Trainer("Juan", "Arteaga", "12384565789b", "Juar", 2L, true, "Pilates");
        trainerDao.update(100L, updatedTrainer);
        assertEquals(null, trainerDao.getById(100L));
    }

    @Test
    void delete_existingTrainer_shouldRemoveTrainer() {
        trainerDao.delete(1L);
        assertEquals(null, trainerDao.getById(1L));
    }

    @Test
    void delete_nonExistingTrainer_shouldNotRemove() {
        trainerDao.delete(100L);
        assertEquals(null, trainerDao.getById(100L));
    }

}