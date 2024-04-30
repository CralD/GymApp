package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TraineeDaoTest {

    @Mock
    private CommonInMemoryStorage storageMock;

    @InjectMocks
    private TraineeDao traineeDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Map<Long, Trainee> trainees = new HashMap<>();
        trainees.put(1L, new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50"));
        trainees.put(2L, new Trainee("Juan", "Naranjas", "12384565789b", "Juna", 2L, false, LocalDate.of(1980, 10, 22), "calle 45 carrera 87"));
        when(storageMock.getTrainees()).thenReturn(trainees);
        traineeDao = new TraineeDao(storageMock);
    }

    @Test
    void getById_existingTrainee_shouldReturnTrainee() {
        Trainee trainee = traineeDao.getById(1L);
        assertEquals("Ana", trainee.getFirstName());
    }

    @Test
    void getById_nonExistingTrainee_shouldReturnNull() {
        Trainee trainee = traineeDao.getById(100L);
        assertEquals(null, trainee);
    }

    @Test
    void save_newTrainee_shouldAddTrainee() {
        Trainee newTrainee = new Trainee("Rodrigo","perez","ro1111pe","Rope",3L,true,LocalDate.of(2001,7,9),"calle 7 carrera 2");
        traineeDao.save(3L, newTrainee);
        assertEquals(newTrainee, traineeDao.getById(3L));
    }

    @Test
    void update_existingTrainee_shouldUpdateTrainee() {
        Trainee updatedTrainee = new Trainee("Juan", "Arreaga", "12384565789b", "Juar", 2L, false, LocalDate.of(1980, 10, 22), "calle 45 carrera 87");
        traineeDao.update(2L, updatedTrainee);
        assertEquals(updatedTrainee, traineeDao.getById(2L));
    }

    @Test
    void update_nonExistingTrainee_shouldNotUpdate() {
        Trainee updatedTrainee = new Trainee("Juan", "Arreaga", "12384565789b", "Juar", 2L, false, LocalDate.of(1980, 10, 22), "calle 45 carrera 87");
        traineeDao.update(100L, updatedTrainee);
        assertEquals(null, traineeDao.getById(100L));
    }

    @Test
    void delete_existingTrainee_shouldRemoveTrainee() {
        traineeDao.delete(1L);
        assertEquals(null, traineeDao.getById(1L));
    }

    @Test
    void delete_nonExistingTrainee_shouldNotRemove() {
        traineeDao.delete(100L);
        assertEquals(null, traineeDao.getById(100L));
    }

}