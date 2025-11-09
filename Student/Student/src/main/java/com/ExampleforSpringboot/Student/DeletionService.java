package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletionService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public DeletionService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public String deleteStudentById(int id){
        return studentRepository.deleteStudentById(id);
    }

    public String deleteTeacherById(int id) {
        return teacherRepository.deleteTeacherById(id);
    }
}