package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.TrainerDao;
import com.epam.gymapplication.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    TrainerDao trainerDao;

    @Autowired
    public TrainerService(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    public void createTrainer(Trainer trainer){
        trainerDao.createTrainer(trainer);
    }
    public void updateTrainer(Trainer trainer){
        trainerDao.updateTrainer(trainer);
    }

    public Trainer selectTrainer(String id){
        return trainerDao.selectTrainerById(id);
    }
}
