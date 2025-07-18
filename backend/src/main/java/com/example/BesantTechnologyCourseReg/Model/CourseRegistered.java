package com.example.BesantTechnologyCourseReg.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class CourseRegistered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    private String name;

    @Column(unique = true)         // Make DB allow Unique value
    private String mobileNum;

    @Column(unique = true)         // Make DB allow Unique value
    private String emailId;

    private String location;
    private String courseName;
    private String batchTime;
    private String profession;
    private String interestedInTrainer;

    public CourseRegistered() {}

    public CourseRegistered(LocalDate date, String name, String mobileNum, String emailId, String location, String courseName, String batchTime, String profession, String interestedInTrainer) {
        this.date = date;
        this.name = name;
        this.mobileNum = mobileNum;
        this.emailId = emailId;
        this.location = location;
        this.courseName = courseName;
        this.batchTime = batchTime;
        this.profession = profession;
        this.interestedInTrainer = interestedInTrainer;
    }
}
