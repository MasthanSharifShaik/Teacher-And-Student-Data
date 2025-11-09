package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    private final DeletionService deletionService;
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService, DeletionService deletionService) {
        this.studentService = studentService;
        this.deletionService = deletionService;
    }

    @PostMapping
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public String getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }
}