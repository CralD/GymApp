package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Training;

public class TrainingDao {
    private Storage storage;
    private TrainerDao trainerDao;
    private TraineeDao traineeDao;

    public TrainingDao(CommonInMemoryStorage storage) {
        this.storage = storage;
    }

    public void createTraining(Training training) {
        if (training.getTraineeId() == null || training.getTrainerId() == null){
            throw new IllegalArgumentException("User id not found");
        }else {
            storage.save(training.getTraineeId() != null ? training.getTraineeId() : training.getTrainerId(), training);
        }
    }

    public Training selectTraining(String id){
        return (Training) storage.getById(id);
    }
}
