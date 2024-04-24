package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Training;

public class TrainingDao {
    private Storage storage;

    public TrainingDao(CommonInMemoryStorage storage) {
        this.storage = storage;
    }

    public void createTraining(Training training) {
       storage.save(training.getTraineeId(), training);
    }

    public Training selectTraining(String id){
        return (Training) storage.getById(id);
    }
}
