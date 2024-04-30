package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.dao.TraineeDao;
import com.epam.gymapplication.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {
    private Storage<Trainee> traineeDao;

    @Autowired
    public TraineeService(Storage<Trainee> traineeDao) {
        this.traineeDao = traineeDao;
    }

    public Trainee getTraineeById(Long id) {
        return traineeDao.getById(id);
    }

    public void saveTrainee(Long id, Trainee trainee) {
        traineeDao.save(id, trainee);
    }

    public void updateTrainee(Long id, Trainee trainee) {
        traineeDao.update(id, trainee);
    }

    public void deleteTrainee(Long id) {
        traineeDao.delete(id);
    }
}
