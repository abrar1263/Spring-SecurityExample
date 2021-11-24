package com.perfectsqaure.SpringSecurity.project.model;


import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long projId;

    private String projectName;
    private int DurationInMinutes;

    public Project() {
    }

    public Project(long projId, String projectName, int durationInMinutes) {
        this.projId = projId;
        this.projectName = projectName;
        DurationInMinutes = durationInMinutes;
    }

    public long getProjId() {
        return projId;
    }

    public void setProjId(long projId) {
        this.projId = projId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDurationInMinutes() {
        return DurationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        DurationInMinutes = durationInMinutes;
    }


    @Override
    public String toString() {
        return "Project{" +
                "projId=" + projId +
                ", projectName='" + projectName + '\'' +
                ", DurationInMinutes=" + DurationInMinutes +
                '}';
    }
}
