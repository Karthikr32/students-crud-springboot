package com.example.BesantTechnologyCourseReg.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    private int id;
    private String courseName;
    private String trainer;
    private int durationInWeeks;
}
