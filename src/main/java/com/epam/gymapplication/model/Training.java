package com.epam.gymapplication.model;

import java.util.Date;

public class Training {

    private String trainingName;
    private String trainingType;
    private Date trainingDate;
    private  int trainingDuration;

    private long trainee;

    private Long trainer;


    public Training(String trainingName, String trainingType, Date trainingDate, int trainingDuration, Trainee trainee, Trainer trainer) {
        this.trainingName = trainingName;
        this.trainingType = trainingType;
        this.trainingDate = trainingDate;
        this.trainingDuration = trainingDuration;
        this.trainee = trainee.getId();
        this.trainer = trainer.getId();
    }

    public String getTrainingName() {

        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public int getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(int trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public Long getTraineeId() {
        return trainee;
    }

    public void setTrainee(Long trainee) {
        this.trainee = trainee;
    }

    public Long getTrainerId() {
        return trainer;
    }

    public void setTrainer(Long trainer) {
        this.trainer = trainer;
    }
}
