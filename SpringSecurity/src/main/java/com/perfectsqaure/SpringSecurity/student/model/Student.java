package com.perfectsqaure.SpringSecurity.student.model;


import com.perfectsqaure.SpringSecurity.project.model.Project;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String mobNumber;
    private String emailAddress;

    @OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk",referencedColumnName = "id")
    private List<Project> project;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, String mobNumber, String emailAddress, List<Project> project) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobNumber = mobNumber;
        this.emailAddress = emailAddress;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobNumber='" + mobNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", project=" + project +
                '}';
    }
}
