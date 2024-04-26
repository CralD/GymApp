package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.TraineeDao;
import com.epam.gymapplication.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {
    private TraineeDao traineeDao;

    @Autowired
    public TraineeService(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }

    public void createTrainee(Trainee trainee){
        traineeDao.createTrainee(trainee);
    }

    public void updateTrainee(Trainee trainee){
        traineeDao.updateTrainee(trainee);
    }

    public void deleteTrainee(Trainee trainee){
        traineeDao.deleteTrainee(trainee);
    }

    public Trainee selecTrainee(String id){
       return traineeDao.selectTraineeById(id);
    }
}
