package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import com.epam.gymapplication.services.TrainingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonInMemoryStorage {




    private Map<Long, Trainee> trainees;
    private Map<Long, Trainer> trainers;
    private Map<Long, Training> trainings;
    public CommonInMemoryStorage() {
        this.trainees = new HashMap<>();
        this.trainers = new HashMap<>();
        this.trainings = new HashMap<>();
    }



    public Map<Long, Trainee> getTrainees() {
        return trainees;
    }

    public Map<Long, Trainer> getTrainers() {
        return trainers;
    }

    public Map<Long, Training> getTrainings() {
        return trainings;
    }


}
