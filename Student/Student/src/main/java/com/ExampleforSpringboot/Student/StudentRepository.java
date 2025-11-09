package com.ExampleforSpringboot.Student;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;



@Repository
public class StudentRepository {
    Map<Integer,Student> map;
    public StudentRepository() {
        map = new HashMap<>();
    }



    public String addStudent(Student student) {
        if(!map.containsKey(student.getId())) {
            if(student.getAge() > 18) {
                map.put(student.getId(), student);
                return "Student added successfully";
            }
            return "student is less than 18";
        }
        return "Student already exists with this ID";
    }



    public String getStudentById(int id) {
        if(map.containsKey(id)) {
            Student student = map.get(id);
            return "Here are the student details:\n" +
                    "ID: " + student.getId() + "\n" +
                    "Name: " + student.getName() + "\n" +
                    "Age: " + student.getAge();
        }
        return "Student not found";
    }



    public String getAllStudents(){
        StringBuilder sb = new StringBuilder();
        for(Student student : map.values()){
            sb.append("here all student details: ").append("\n")
                    .append("student id - ").append(student.getId()).append("\n")
                    .append(" student name - ").append(student.getName()).append("\n")
                    .append(" student age - ").append(student.getAge()).append("\n");
        }
        return sb.toString();
    }



    public String deleteStudentById(int id) {
        if(map.containsKey(id)) {
           map.remove(id);
            return "student deleted successfully";
        }
        return "student not found with this ID to delete";
    }
}