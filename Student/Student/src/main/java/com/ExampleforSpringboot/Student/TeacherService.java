package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherService (TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    public String getTeacherById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public String getAllTeachers(){
        return teacherRepository.getAllTeachers();
    }

    public String deleteTeacherById(int id) {
        return teacherRepository.deleteTeacherById(id);
    }
}