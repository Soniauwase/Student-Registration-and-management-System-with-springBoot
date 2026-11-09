package com.example.StudentRegistration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private  StudentServices studentServices;

  public StudentController(StudentServices studentServices){
      this.studentServices=studentServices;

  }
  @GetMapping("/register")
  public  String showRegistrationForm(Model model){
      model.addAttribute("student",new Student());
      return "register";

  }
  @PostMapping("/register")
  public  String registerStudent(@ModelAttribute("student") Student student, Model model ){
      try{
          boolean success=studentServices.registeringStudent(student);
          if (success){
              System.out.println(model.addAttribute("success message","student Registered successfully!"));
          }
          return  "register";
      } catch (Exception e) {
          model.addAttribute("error message", e.getMessage());
      }
      return "register";
  }
  @PostMapping("/all")
  public String listOfAllStudent(Model model){
      List<Student>students=studentServices.getAllStudent();
      model.addAttribute("student",students);
      return  "students";

  }



}
