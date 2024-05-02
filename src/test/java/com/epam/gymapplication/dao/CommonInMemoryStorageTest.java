package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CommonInMemoryStorageTest {
    @Mock
    private CommonInMemoryStorage storageMock;
    @MockBean
    private ObjectMapper objectMapper;

    private Map<Long, Trainee> trainees;
    private Map<Long, Trainer> trainers;
    private Map<Long, Training> trainings;

    Trainee trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
    Trainer trainer = new Trainer("Juan", "Arteaga", "12384565789b", "Juar", 1L, true, "Pilates");


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        trainees = new HashMap<>();
        trainers = new HashMap<>();
        trainings = new HashMap<>();

        trainees.put(1L, new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50"));
        trainers.put(1L,new Trainer("Ana", "Arteaga", "123456789a", "Anar", 1L, true,  "Fitness")) ;
        trainings.put(1L, new Training("Pilates", "Agility", new Date(), 60,trainee,trainer));
        when(storageMock.getTrainees()).thenReturn(trainees);
        when(storageMock.getTrainers()).thenReturn(trainers);
        when(storageMock.getTrainings()).thenReturn(trainings);
    }

    @Test
    public void getTraineesTest() {
        Map<Long, Trainee> trainees = storageMock.getTrainees();
        assertNotNull(trainees);
    }

    @Test
    public void getTrainersTest() {
        Map<Long, Trainer> trainers = storageMock.getTrainers();
        assertNotNull(trainers);
    }

    @Test
    public void getTrainingsTest() {
        Map<Long, Training> trainings = storageMock.getTrainings();
        assertNotNull(trainings);
    }



}