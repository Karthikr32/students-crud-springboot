package com.example.BesantTechnologyCourseReg.Repository;

import com.example.BesantTechnologyCourseReg.Model.CourseRegistered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegRepo extends JpaRepository<CourseRegistered, Integer> {
    boolean existsByEmailIdOrMobileNum(String emailId, String mobileNum);
}
