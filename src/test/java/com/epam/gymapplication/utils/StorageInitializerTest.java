package com.epam.gymapplication.utils;
import com.epam.gymapplication.dao.CommonInMemoryStorage;
import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import com.epam.gymapplication.services.TraineeService;
import com.epam.gymapplication.utils.StorageInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Properties;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class StorageInitializerTest {
  /*  @Mock
    private CommonInMemoryStorage storage;

    @Mock
    private Environment env;

    @InjectMocks
    private StorageInitializer storageInitializer;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitializeStorage() throws IOException {

        String traineeFilePath = "src/main/resources/data/traineeFile.csv";
        String trainerFilePath = "src/main/resources/data/trainerFile.csv";
        String trainingFilePath = "src/main/resources/data/trainingFile.csv";

        when(env.getProperty("traineeFilePath")).thenReturn(traineeFilePath);
        when(env.getProperty("trainerFilePath")).thenReturn(trainerFilePath);
        when(env.getProperty("trainingFilePath")).thenReturn(trainingFilePath);



        storageInitializer.initializeStorage();

        // Add assertions or verifications here
        verify(env, times(1)).getProperty("traineeFilePath");
        verify(env, times(1)).getProperty("trainerFilePath");
        verify(env, times(1)).getProperty("trainingFilePath");
    }*/



}