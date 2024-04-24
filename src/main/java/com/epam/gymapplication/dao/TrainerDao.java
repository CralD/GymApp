package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainer;

public class TrainerDao {

    private Storage storage;

    public TrainerDao(CommonInMemoryStorage storage) {

        this.storage = storage;
    }

    public void createTrainer(Trainer trainer) {
        storage.save(trainer.getId(), trainer);
    }
    public Trainer selectTrainerById(String id){

        return (Trainer) storage.getById(id);
    }
    public  void updateTrainer(Trainer trainer){

        storage.update(trainer.getId(),trainer);
    }

}
