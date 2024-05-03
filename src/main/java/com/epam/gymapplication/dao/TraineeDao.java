package com.epam.gymapplication.dao;

import com.epam.gymapplication.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TraineeDao implements Storage<Trainee> {
    private Storage storage;
    private Map<Long, Trainee> trainees;

    @Autowired
    public TraineeDao(CommonInMemoryStorage storage) {

        this.trainees = storage.getTrainees();
    }



    @Override
    public Trainee getById(Long id) {
        return trainees.get(id);
    }

    @Override
    public void save(Long id, Trainee trainee) {

        trainees.put(id,trainee);
    }

    @Override
    public void update(Long id, Trainee trainee) {

        if(trainees.containsKey(id)) {
            trainees.put(id, trainee);
        }
    }

    @Override
    public void delete(Long id) {

        trainees.remove(id);
    }

    @Override
    public boolean existByuserName(String username) {
        return trainees.values().stream().anyMatch(t -> t.getUserName().equals(username));
    }


}
