package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;

import com.epam.gymapplication.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class TrainerServiceTest {

    @InjectMocks
    private TrainerService trainerService;

    @Mock
    private Storage<Trainer> trainerDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Trainer trainer = new Trainer("Ana", "Arteaga", "123456789a", "Anar", 1L, true,  "Fitness");
        Trainer trainer2 = new Trainer("Juan", "Gonzales", "newpassword", "newusername", 2L, true,  "Strength");


    }

    @Test
    public void testGetTraineeById() {
        Trainer trainer = new Trainer("Ana", "Arteaga", "123456789a", "Anar", 1L, true,  "Fitness");
        trainer.setId(1L);
        when(trainerDao.getById(1L)).thenReturn(trainer);

        Trainer result = trainerService.getTrainerById(1L);
        assertEquals(trainer, result);
    }

    @Test
    public void testSaveTrainee() {
        Trainer trainee = new Trainer("Ana", "Arteaga", "123456789a", "Anar", 1L, true,  "Fitness");


        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            Trainer traineeArg = invocation.getArgument(1);
            assertEquals("Ana.Arteaga", traineeArg.getUserName());
            assertNotNull(traineeArg.getPassword());
            assertEquals(10, traineeArg.getPassword().length());
            return null;
        }).when(trainerDao).save(anyLong(), any(Trainer.class));

        trainerService.saveTrainer(1L, trainee);

        verify(trainerDao, times(1)).save(anyLong(), any(Trainer.class));
    }



    @Test
    public void testUpdateTrainee() {
        Trainer trainer = new Trainer("Juan", "Rodriguez", "", "", 1L, true, "Fitness");


        doNothing().when(trainerDao).update(anyLong(), any(Trainer.class));

        trainerService.updateTrainer(1L, trainer);
        assertEquals("Juan",trainer.getFirstName(), "should be the same");
        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            Trainer traineeArg = invocation.getArgument(1);
            assertEquals("Juan.Rodriguez", traineeArg.getUserName());
            assertNotNull(traineeArg.getPassword());
            assertEquals(10, traineeArg.getPassword().length());
            return null;
        }).when(trainerDao).save(anyLong(), any(Trainer.class));



        verify(trainerDao, times(1)).update(anyLong(), any(Trainer.class));
    }



    @Test
    public void testGenerateUsernameWithExistingUser() {

        Trainer existingTrainer = new Trainer("Ana", "Arteaga", "existingPassword", "ExistingUser", 2L, true, "Fitness");
        when(trainerDao.existByuserName("Ana.Arteaga")).thenReturn(true);
        when(trainerDao.getById(2L)).thenReturn(existingTrainer);


        Trainer newTrainer = new Trainer("Ana", "Arteaga", "newPassword", "NewUser", 3L, true, "Fitness");
        trainerService.saveTrainer(3L, newTrainer);


        ArgumentCaptor<Trainer> trainerCaptor = ArgumentCaptor.forClass(Trainer.class);
        verify(trainerDao).save(anyLong(), trainerCaptor.capture());
        Trainer savedTrainer = trainerCaptor.getValue();
        assertEquals("Ana.Arteaga1", savedTrainer.getUserName());
    }


}