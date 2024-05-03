package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TrainingService {
    private Storage<Training> trainingDao;
    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class);

    @Autowired
    public TrainingService(Storage<Training> trainingDao) {
        this.trainingDao = trainingDao;
    }


    public Training getTrainingById(Long id) {
        return trainingDao.getById(id);
    }

    public void saveTraining(Long id, Training training) {
        trainingDao.save(id, training);
        logger.info("Training saved with id: {}", id);
    }


}
