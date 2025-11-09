package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public String  getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    public String getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public String deleteStudentById(int id){
        return studentRepository.deleteStudentById(id);
    }
}