package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public class TrainingDao implements Storage<Training> {
    private Storage storage;
    private Map<Long, Training> trainings;


    @Autowired
    public TrainingDao(CommonInMemoryStorage storage) {
        this.trainings = storage.getTrainings();
    }

    @Override
    public Training getById(Long id) {

        return trainings.get(id);
    }

    @Override
    public void save(Long id, Training training) {

        trainings.put(id,training);
    }

    @Override
    public void update(Long id, Training training) {

        if(trainings.containsKey(id)) {
            trainings.put(id, training);
        }
    }

    @Override
    public void delete(Long id) {

        trainings.remove(id);
    }

    @Override
    public boolean existByuserName(String username) {
        return false;
    }


}
