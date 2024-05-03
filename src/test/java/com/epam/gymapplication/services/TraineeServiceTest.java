package com.epam.gymapplication.services;
import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.model.Trainee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class TraineeServiceTest {

    @InjectMocks
    private TraineeService traineeService;

    @Mock
    private Storage<Trainee> traineeDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Trainee trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
        Trainee trainee2 = new Trainee("Joan", "Rodriguez", "", "Joan.Rodriguez", 3L, true, LocalDate.of(1945, 11, 15), "calle 42 carrera 59");


    }

    @Test
    public void testGetTraineeById() {
        Trainee trainee = new Trainee("Ana", "Arteaga", "123456789a", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");
        trainee.setId(1L);
        when(traineeDao.getById(1L)).thenReturn(trainee);

        Trainee result = traineeService.getTraineeById(1L);
        assertEquals(trainee, result);
    }

    @Test
    public void testSaveTrainee() {
        Trainee trainee = new Trainee("Ana", "Arteaga", "123", "Anar", 1L, true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50");


        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            Trainee traineeArg = invocation.getArgument(1);
            assertEquals("Ana.Arteaga", traineeArg.getUserName());
            assertNotNull(traineeArg.getPassword());
            assertEquals(10, traineeArg.getPassword().length());
            return null;
        }).when(traineeDao).save(anyLong(), any(Trainee.class));

        traineeService.saveTrainee(1L, trainee);

        verify(traineeDao, times(1)).save(anyLong(), any(Trainee.class));
    }
    @Test
    public void testSaveTraineeWithSameName() {

    }



    @Test
    public void testUpdateTrainee() {
        Trainee trainee = new Trainee("Juan", "Rodriguez", "", "", 1L, true, LocalDate.of(1945, 11, 15), "calle 42 carrera 59");


        doNothing().when(traineeDao).update(anyLong(), any(Trainee.class));

        traineeService.updateTrainee(1L, trainee);
        assertEquals("Juan",trainee.getFirstName(), "should be the same");
        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            Trainee traineeArg = invocation.getArgument(1);
            assertEquals("Juan.Rodriguez", traineeArg.getUserName());
            assertNotNull(traineeArg.getPassword());
            assertEquals(10, traineeArg.getPassword().length());
            return null;
        }).when(traineeDao).save(anyLong(), any(Trainee.class));



        verify(traineeDao, times(1)).update(anyLong(), any(Trainee.class));
    }

    @Test
    void deleteTrainee() {
        traineeService.deleteTrainee(1L);
        assertEquals(null, traineeService.getTraineeById(1L));
    }

    @Test
    public void testGenerateUsernameWithExistingUser() {

        Trainee existingTrainee = new Trainee("Ana", "Arteaga", "existingPassword", "ExistingUser", 2L, true, LocalDate.of(1990, 1, 1), "existingAddress");
        when(traineeDao.existByuserName("Ana.Arteaga")).thenReturn(true);
        when(traineeDao.getById(2L)).thenReturn(existingTrainee);


        Trainee newTrainee = new Trainee("Ana", "Arteaga", "newPassword", "NewUser", 3L, true, LocalDate.of(1990, 1, 1), "newAddress");
        traineeService.saveTrainee(3L, newTrainee);


        ArgumentCaptor<Trainee> traineeCaptor = ArgumentCaptor.forClass(Trainee.class);
        verify(traineeDao).save(anyLong(), traineeCaptor.capture());
        Trainee savedTrainee = traineeCaptor.getValue();
        assertEquals("Ana.Arteaga1", savedTrainee.getUserName());
    }





}