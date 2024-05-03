package com.epam.gymapplication.utils;

import com.epam.gymapplication.dao.CommonInMemoryStorage;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.config.BeanPostProcessor;


import org.springframework.core.env.Environment;

import org.springframework.stereotype.Component;


import java.io.*;

import java.time.LocalDate;


@Component
public class StorageInitializer implements BeanPostProcessor {
    private CommonInMemoryStorage storage;
    @Autowired
    private Environment environment;





    @Autowired
    public StorageInitializer(CommonInMemoryStorage storage) {
        this.storage = storage;
        System.out.println("Initializing storage...");

    }
    @PostConstruct
    public void initializeStorage() {


        System.out.println("Reading trainee data...");
        readDataFromFile(environment.getProperty("traineeFilePath"), "Trainee");
        System.out.println("Reading trainer data...");
        readDataFromFile(environment.getProperty("trainerFilePath"), "Trainer");
        System.out.println("Reading training data...");
        readDataFromFile(environment.getProperty("trainingFilePath"), "Training");


    }


    public void readDataFromFile(String filePath, String type) {


        System.out.println("Reading data from file: " + filePath + ", type: " + type);


        System.out.println("method is called 2 ");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null ) {
                String[] data = line.split(",");

                if ("Trainee".equals(type)) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String password = data[2];
                    String userName = data[3];
                    Long id = Long.parseLong(removeQuotes(removeQuotes(data[4])));
                    boolean isActive = Boolean.parseBoolean(data[5]);

                    LocalDate dateOfBirth = LocalDate.parse(data[6]);
                    System.out.println("cada vez que pase por aca" + " " + data[6]);
                    String address = data[7];


                    Trainee trainee = new Trainee(firstName, lastName, password, userName, id, isActive, dateOfBirth, address);
                    storage.getTrainees().put(id, trainee);
                } else if ("Trainer".equals(type)) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String userName = data[2];
                    String password = data[3];
                    Long id = Long.parseLong(removeQuotes(removeQuotes(data[4])));
                    boolean isActive = Boolean.parseBoolean(data[5]);
                    String specialization = data[6];
                    Trainer trainer = new Trainer(firstName, lastName, userName, password, id, isActive, specialization);
                    storage.getTrainers().put(id, trainer);
                } else if ("Training".equals(type)) {


                    String trainingName = data[0];
                    String trainingType = data[1];
                    LocalDate trainingDate = LocalDate.parse(data[2]);
                    int trainingDuration = Integer.parseInt(data[3]);
                    Long traineeId = Long.parseLong(data[4]);
                    Long trainerId = Long.parseLong(data[5]);
                    Trainee trainee = storage.getTrainees().get(traineeId);
                    System.out.println("aca vamos " + trainee.getId());
                    Trainer trainer = storage.getTrainers().get(trainerId);

                    if (trainee != null && trainer != null) {

                       // Training training = new Training(trainingName, trainingType, trainingDate, trainingDuration, new Trainee("Ana", "Arteaga", "123456789a", "Anar",trainee.getId() , true, LocalDate.of(1990, 1, 1), "calle 30 carrera 50"),
                             //   new Trainer("Juan", "Arteaga", "12384565789b", "Juar", trainer.getId(), true, "Pilates"));
                        Training training = new Training(trainingName, trainingType, trainingDate, trainingDuration, trainee, trainer);
                        System.out.println(training.getTrainingName() + training.getTrainingType() + training.getTrainingDate() + training.getTrainingDuration()+ trainee.getId() + trainer.getId() + "aca es el ultimo print que coloque");
                        storage.getTrainings().put(trainee.getId(), training);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String removeQuotes(String input) {
        return input.replaceAll("\"", "");
    }
}
