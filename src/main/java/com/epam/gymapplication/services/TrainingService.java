package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.dao.TrainingDao;
import com.epam.gymapplication.model.Trainer;
import com.epam.gymapplication.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    private Storage<Training> trainingDao;

    @Autowired
    public TrainingService(Storage<Training> trainingDao) {
        this.trainingDao = trainingDao;
    }


    public Training getTrainerById(Long id) {
        return trainingDao.getById(id);
    }

    public void saveTrainer(Long id, Training training) {
        trainingDao.save(id, training);
    }


}
