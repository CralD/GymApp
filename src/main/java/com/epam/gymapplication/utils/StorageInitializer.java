package com.epam.gymapplication.utils;

import com.epam.gymapplication.dao.CommonInMemoryStorage;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import com.epam.gymapplication.services.TraineeService;
import com.epam.gymapplication.services.TrainerService;
import com.epam.gymapplication.services.TrainingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class StorageInitializer implements BeanPostProcessor {
    private CommonInMemoryStorage storage;

    @Value("${trainerFilePath}")
    private String trainerFilePath;

    @Value("${traineeFilePath}")
    private String traineeFilePath;

    @Value("${trainingFilePath}")
    private String trainingFilePath;

    @Autowired
    public StorageInitializer(CommonInMemoryStorage storage) {
        this.storage = storage;
        System.out.println("Initializing storage...");
    }

    public void initializeStorage() {
        readDataFromFile(trainerFilePath, "Trainer");
        readDataFromFile(traineeFilePath, "Trainee");
        readDataFromFile(trainingFilePath, "Training");
    }

    @PostConstruct
    public void readDataFromFile(String filePath, String type) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");


                Long id = Long.parseLong(data[1]);
                String firstName = data[2];
                String lastName = data[3];
                String password = data[4];
                String userName = data[5];
                boolean isActive = Boolean.parseBoolean(data[6]);

                if ("Trainee".equals(type)) {

                    LocalDate dateOfBirth = LocalDate.parse(data[7]);
                    String address = data[8];
                    Trainee trainee = new Trainee(firstName, lastName, password, userName, id, isActive, dateOfBirth, address);
                    storage.getTrainees().put(id, trainee);
                } else if ("Trainer".equals(type)) {

                    String specialization = data[7];
                    Trainer trainer = new Trainer(firstName, lastName, userName, password, id, isActive, specialization);
                    storage.getTrainers().put(id, trainer);
                } else if ("Training".equals(type)) {

                    String trainingName = data[7];
                    String trainingType = data[8];
                    Date trainingDate = new SimpleDateFormat("yyyy-MM-dd").parse(data[9]);
                    int trainingDuration = Integer.parseInt(data[10]);
                    Long traineeId = Long.parseLong(data[11]);
                    Long trainerId = Long.parseLong(data[12]);
                    Trainee trainee = storage.getTrainees().get(traineeId);
                    Trainer trainer = storage.getTrainers().get(trainerId);
                    if (trainee != null && trainer != null) {
                        Training training = new Training(trainingName, trainingType, trainingDate, trainingDuration, trainee, trainer);
                        storage.getTrainings().put(id, training);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
