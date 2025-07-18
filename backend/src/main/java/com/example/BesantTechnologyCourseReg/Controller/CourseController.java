package com.example.BesantTechnologyCourseReg.Controller;


import com.example.BesantTechnologyCourseReg.Model.Course;
import com.example.BesantTechnologyCourseReg.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CourseController {

    private final CourseService service;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }
}
