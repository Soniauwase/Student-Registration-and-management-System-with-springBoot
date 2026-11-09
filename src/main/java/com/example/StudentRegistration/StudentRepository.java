package com.example.StudentRegistration;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {


    public boolean saveStudent(Student student){
        String savesql="insert into students(full_name,age, email) values(?,?,?)";
        try{
            Connection connection=DatabaseConnectivity.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(savesql);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3, student.getEmail());
             int rowsUpdated=preparedStatement.executeUpdate();
             if(rowsUpdated>0){
                 System.out.println(" student saved successfully!");
             }
        } catch (Exception e) {
            e.getMessage();
        }
        return true;
    }
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, full_name, age, email FROM students";

        try (Connection connection = DatabaseConnectivity.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));

                String fullName = rs.getString("full_name");
                String[] names = fullName.split(" ", 2);
                student.setFirst_name(names.length > 0 ? names[0] : "");
                student.setLast_name(names.length > 1 ? names[1] : "");

                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return students;
    }
}








