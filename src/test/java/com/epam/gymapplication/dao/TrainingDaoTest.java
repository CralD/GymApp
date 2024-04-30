package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class TrainingDaoTest {
    @Mock
    private CommonInMemoryStorage storageMock;

    @InjectMocks
    private TrainingDao trainingDao;

    private Map<Long, Training> trainings;

    Trainee trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
    Trainer trainer = new Trainer("Juan", "Arteaga", "12384565789b", "Juar", 1L, true, "Pilates");

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        trainings = new HashMap<>();
        trainings.put(1L, new Training("Pilates", "Agility", new Date(), 60,trainee,trainer));
        when(storageMock.getTrainings()).thenReturn(trainings);
        trainingDao = new TrainingDao(storageMock);
    }

    @Test
    public void getById_existingTraining_shouldReturnTraining() {
        Training training = trainingDao.getById(1L);
        assertEquals("Pilates", training.getTrainingName());
    }
    @Test
    void getById_nonExistingTraining_shouldReturnNull() {
        Training training = trainingDao.getById(100L);
        assertEquals(null, training);
    }

    @Test
    public void save_newTraining_shouldAddTraining() {
        Training newTraining = new Training("Yoga", "Agility", new Date(), 60,trainee,trainer);
        trainingDao.save(2L, newTraining);
        assertEquals(newTraining, trainingDao.getById(2L));
    }

    @Test
    public void update_existingTraining_shouldUpdateTraining() {
        Training updatedTraining = new Training("Aerobics", "Agility", new Date(), 45,trainee,trainer);
        trainingDao.update(1L, updatedTraining);
        assertEquals(updatedTraining, trainingDao.getById(1L));
    }
    @Test
    void update_nonExistingTraining_shouldNotUpdate() {
        Training updatedTraining = new Training("Aerobics", "Agility", new Date(), 45,trainee,trainer);
        trainingDao.update(100L, updatedTraining);
        assertEquals(null, trainingDao.getById(100L));
    }

    @Test
    public void delete_existingTraining_shouldRemoveTraining() {
        trainingDao.delete(1L);
        assertNull(trainingDao.getById(1L));
    }
    @Test
    void delete_nonExistingTraining_shouldNotRemove() {
        trainingDao.delete(100L);
        assertEquals(null, trainingDao.getById(100L));
    }

}