package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherRepository {

    @Autowired
    StudentRepository studentRepository;

    private Map<Integer, Teacher> map;
    public TeacherRepository(StudentRepository studentRepository) {
        this.map = new HashMap<>();
    }

    private int teacherIdCounter = 1;
    public String addTeacher(Teacher teacher) {
        if (teacher.getId() == 0) {
            teacher.setId(teacherIdCounter++);
        }

        if (!map.containsKey(teacher.getId())) {
            map.put(teacher.getId(), teacher);
            return "Teacher added successfully";
        }
        return "Teacher already exists with this ID";
    }

    public String getTeacherById(int id) {
        if (map.containsKey(id)) {
            Teacher teacher = map.get(id);
            StringBuilder sb = new StringBuilder();
            sb.append("Teacher Details:\n")
                    .append("ID: ").append(teacher.getId()).append("\n")
                    .append("Name: ").append(teacher.getName()).append("\n")
                    .append("Students:\n");

            for (int studentId : teacher.getStudentIds()) {
                sb.append(studentRepository.getStudentById(studentId)).append("\n");
            }

            return sb.toString();
        }
        return "Teacher not found";
    }

//    public String getAllTeachers() {
//        StringBuilder sb = new StringBuilder();
//        for (Teacher teacher : map.values()) {
//            sb.append(getTeacherById(teacher.getId())).append("\n");
//        }
//        return sb.toString();
//    }

    public String getAllTeachers() {
        StringBuilder sb = new StringBuilder();
        for (Teacher teacher : map.values()) {
            sb.append("Here are the teacher details:").append("\n")
                    .append("Teacher ID - ").append(teacher.getId()).append("\n")
                    .append("Teacher Name - ").append(teacher.getName()).append("\n")
                    .append("Students:").append("\n");
            for(Student student : studentRepository.map.values()) {
                if(teacher.getStudentIds().contains(student.getId())) {
                    sb.append("  Student ID - ").append(student.getId()).append("\n")
                            .append("  Student Name - ").append(student.getName()).append("\n")
                            .append("  Student Age - ").append(student.getAge()).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String deleteTeacherById(int id) {
        if (map.containsKey(id)) {
            map.remove(id);
            return "Teacher deleted successfully";
        }
        return "Teacher not found with this ID to delete";
    }
}