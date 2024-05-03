package com.epam.gymapplication.services;

import com.epam.gymapplication.dao.Storage;
import com.epam.gymapplication.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.SecureRandom;
import java.util.stream.Collectors;


@Service
public class TraineeService {
    private Storage<Trainee> traineeDao;
    private static final Logger logger = LoggerFactory.getLogger(TraineeService.class);

    @Autowired
    public TraineeService(Storage<Trainee> traineeDao) {
        this.traineeDao = traineeDao;
    }

    public Trainee getTraineeById(Long id) {
        return traineeDao.getById(id);
    }

    public void saveTrainee(Long id, Trainee trainee) {
        String username = generateUsername(trainee.getFirstName(), trainee.getLastName());
        String password = generatePassword();
        trainee.setUserName(username);
        trainee.setPassword(password);
        traineeDao.save(id, trainee);
        logger.info("Trainee saved with id: {}", id);
    }

    public void updateTrainee(Long id, Trainee trainee) {
        String username = generateUsername(trainee.getFirstName(), trainee.getLastName());
        String password = generatePassword();
        trainee.setUserName(username);
        trainee.setPassword(password);
        traineeDao.update(id, trainee);
        logger.info("Trainee updated with id: {}", id);
    }

    public void deleteTrainee(Long id) {
        traineeDao.delete(id);
        logger.info("Trainee deleted with id: {}", id);
    }
    private String generateUsername(String firstName, String lastName) {
        String baseUsername = firstName + "." + lastName;
        String username = baseUsername;
        int suffix = 1;
        while (traineeDao.existByuserName(username)) {
            username = baseUsername + suffix++;
        }
        return username;
    }
    private String generatePassword() {
        SecureRandom random = new SecureRandom();
        return random.ints(48, 122)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .mapToObj(i -> String.valueOf((char) i))
                .limit(10)
                .collect(Collectors.joining());
    }


}
