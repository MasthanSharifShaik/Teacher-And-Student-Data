package com.ExampleforSpringboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final DeletionService deletionService;
    @Autowired
    public TeacherController(TeacherService teacherService, DeletionService deletionService) {
        this.teacherService = teacherService;
        this.deletionService = deletionService;
    }

    @PostMapping("/add")
    public String addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public String getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/all")
    public String getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id}")
    public String deleteTeacherById(@PathVariable int id) {
        return teacherService.deleteTeacherById(id);
    }
}