package com.example.BesantTechnologyCourseReg.Repository;

import com.example.BesantTechnologyCourseReg.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
