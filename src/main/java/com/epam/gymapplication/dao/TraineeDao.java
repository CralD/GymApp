package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;

public class TraineeDao {
    private Storage storage;

    public TraineeDao(CommonInMemoryStorage storage) {

        this.storage = storage;
    }

    public void createTrainee(Trainee trainee){

        storage.save(trainee.getId(),trainee);
    }
    public Trainee selectTraineeById(String id){

        return (Trainee) storage.getById(id);
    }
    public void updateTrainee(Trainee trainee){
        storage.update(trainee.getId(),trainee);
    }

    public void deleteTrainee(Trainee trainee){
        storage.delete(trainee.getId());
    }
}
