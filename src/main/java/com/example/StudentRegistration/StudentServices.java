package com.example.StudentRegistration;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    private  StudentRepository studentRepository;
private StudentServices(StudentRepository studentRepository){
    this.studentRepository=studentRepository;

}
 public boolean registeringStudent(Student student){
    if(student.getAge()>18){
        System.out.println("age should be greater than 18");
    }
    return  studentRepository.saveStudent(student);
 }
  public List<Student> getAllStudent(){
     return studentRepository.findAll();
  }




}
