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

class StorageInitializerTest {
    @Mock
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
        String trainerFilePath = "src/main/resources/trainerFile.csv";
        String traineeFilePath = "src/main/resources/traineeFile.csv";
        String trainingFilePath = "src/main/resources/trainingFile.csv";

        when(env.getProperty("trainerFilePath")).thenReturn(trainerFilePath);
        when(env.getProperty("traineeFilePath")).thenReturn(traineeFilePath);
        when(env.getProperty("trainingFilePath")).thenReturn(trainingFilePath);

        // Mock storage method calls if needed
        // For example:
        // when(storage.getTrainees()).thenReturn(new HashMap<>());
        // when(storage.getTrainers()).thenReturn(new HashMap<>());
        // when(storage.getTrainings()).thenReturn(new HashMap<>());

        storageInitializer.initializeStorage();

        // Add assertions or verifications here
    }



}