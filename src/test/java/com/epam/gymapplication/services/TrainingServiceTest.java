package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.dao.TrainingDao;
import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrainingServiceTest {


    @Mock
    private Storage<Training> trainingDao;
    @InjectMocks
    private TrainingService trainingService;


    Trainee trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
    Trainer trainer = new Trainer("Juan", "Arteaga", "12384565789b", "Juar", 1L, true, "Pilates");

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        Training training = new Training("Pilates", "Agility", LocalDate.of(1990, 1, 1), 60,trainee,trainer);


        when(trainingDao.getById(trainee.getId())).thenReturn(training);

    }

    @Test
    public void testGetTrainingById() {
        Training training = new Training("Pilates", "Agility", LocalDate.of(1990, 1, 1), 60,trainee,trainer);
        training.getTraineeId();
        when(trainingDao.getById(1L)).thenReturn(training);

        Training result = trainingService.getTrainingById(1L);

        assertEquals(training, result);
        verify(trainingDao, times(1)).getById(1L);
    }

    @Test
    public void testSaveTraining() {
        Training training = new Training("Yoga", "Agility", LocalDate.of(1996, 11, 12), 60,trainee,trainer);
        doNothing().when(trainingDao).save(anyLong(), any(Training.class));

        trainingService.saveTraining(1L, training);

        verify(trainingDao, times(1)).save(anyLong(), any(Training.class));
    }

}