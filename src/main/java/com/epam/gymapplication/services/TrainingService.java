package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.TrainingDao;
import com.epam.gymapplication.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    TrainingDao trainingDao;

    @Autowired
    public TrainingService(TrainingDao trainingDao) {
        this.trainingDao = trainingDao;
    }


    public void createTraining(Training training){
        trainingDao.createTraining(training);
    }

    public Training selectTraining(String id){
        return trainingDao.selectTraining(id);
    }
}
