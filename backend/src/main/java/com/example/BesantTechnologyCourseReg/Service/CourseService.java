package com.example.BesantTechnologyCourseReg.Service;

import com.example.BesantTechnologyCourseReg.DTO.CourseRegisterDTO;
import com.example.BesantTechnologyCourseReg.Model.Course;
import com.example.BesantTechnologyCourseReg.Model.CourseRegistered;
import com.example.BesantTechnologyCourseReg.Repository.CourseRegRepo;
import com.example.BesantTechnologyCourseReg.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegRepo courseRegRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<CourseRegistered> getAllEnrolledDetails() {
        return courseRegRepo.findAll();
    }

    public void addAdmission(CourseRegisterDTO user) {
        CourseRegistered newAdmission = new CourseRegistered(user.getDate(), user.getName(), user.getMobileNum(), user.getEmailId(), user.getLocation(), user.getCourseName(), user.getBatchTime(), user.getProfession(), user.getInterestedInTrainer());

        courseRegRepo.save(newAdmission);
    }

    // Method to check if there is any Matching emailId and mobileNum in Repo, It either return true or false
    public boolean isExistedUser(String emailId, String mobileNum) {
        return courseRegRepo.existsByEmailIdOrMobileNum(emailId, mobileNum);
    }

    public void deleteByStudentId(int id) {
        courseRegRepo.deleteById(id);
    }
}
