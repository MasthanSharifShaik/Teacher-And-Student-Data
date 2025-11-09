package com.ExampleforSpringboot.Student;

import java.util.List;

public class Teacher {
    int id;
    String name;
    List<Integer> studentIds;

    public Teacher(int id, String name, List<Integer> studentIds) {
        this.id = id;
        this.name = name;
        this.studentIds = studentIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
