package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class TrainerDao implements Storage<Trainer>{

    private Storage storage;
    private Map<Long, Trainer> trainers;

    @Autowired
    public TrainerDao(CommonInMemoryStorage storage) {

        this.trainers = storage.getTrainers();
    }



    @Override
    public Trainer getById(Long id) {
        return trainers.get(id);
    }

    @Override
    public void save(Long id, Trainer trainer) {

        trainers.put(id,trainer);
    }

    @Override
    public void update(Long id, Trainer trainer) {

        if(trainers.containsKey(id)) {
            trainers.put(id, trainer);
        }
    }

    @Override
    public void delete(Long id) {

        trainers.remove(id);
    }

    @Override
    public boolean existByuserName(String username) {
        return false;
    }
}
