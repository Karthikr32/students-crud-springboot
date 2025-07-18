package com.example.BesantTechnologyCourseReg.Controller;

import com.example.BesantTechnologyCourseReg.DTO.CourseRegisterDTO;
import com.example.BesantTechnologyCourseReg.Model.CourseRegistered;
import com.example.BesantTechnologyCourseReg.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CourseRegisterController {

    private final CourseService service;

    @GetMapping("/courses/enrolled")
    public List<CourseRegistered> getAllEnrolledCourseReg() {
        return service.getAllEnrolledDetails();
    }

    @PostMapping("/courses/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CourseRegisterDTO user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return ResponseEntity.badRequest().body(Map.of("error", "Must fill all the credentials"));

        String regEx = "^[A-Za-z0-9.-_]+@gmail+\\.[A-Za-z]{2,}$";

        if(!user.getEmailId().matches(regEx)) return ResponseEntity.badRequest().body(Map.of("error", "Invalid email address"));

        if (user.getMobileNum().length() != 10) return ResponseEntity.badRequest().body(Map.of("error", "Invalid mobile number"));

        boolean isUserExisted = service.isExistedUser(user.getEmailId(), user.getMobileNum());

        if(isUserExisted) return ResponseEntity.badRequest().body(Map.of("error", "The User is already registered"));

        service.addAdmission(user);
        return ResponseEntity.ok(Map.of("message", "Course registered successfully"));
    }

    @DeleteMapping("/courses/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteByStudentId(id);
        return "Deleted successfully";
    }

}
