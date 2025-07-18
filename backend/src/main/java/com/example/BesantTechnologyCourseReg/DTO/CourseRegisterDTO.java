package com.example.BesantTechnologyCourseReg.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseRegisterDTO {

    @NotNull
    private int id;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String name;

    @NotBlank
    private String mobileNum;

    @Email
    private String emailId;

    @NotBlank
    private String location;

    @NotBlank
    private String courseName;

    @NotBlank
    private String batchTime;

    @NotBlank
    private String profession;

    @NotBlank
    private String interestedInTrainer;
}
