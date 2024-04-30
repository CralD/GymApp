package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.dao.TrainerDao;
import com.epam.gymapplication.model.Trainee;
import com.epam.gymapplication.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private Storage<Trainer> trainerDao;

    @Autowired
    public TrainerService(Storage<Trainer> trainerDao) {
        this.trainerDao = trainerDao;
    }

    public Trainer getTrainerById(Long id) {
        return trainerDao.getById(id);
    }

    public void saveTrainer(Long id, Trainer trainer) {
        trainerDao.save(id, trainer);
    }

    public void updateTrainer(Long id, Trainer trainer) {
        trainerDao.update(id, trainer);
    }


}
