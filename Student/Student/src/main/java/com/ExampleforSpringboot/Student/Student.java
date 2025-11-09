package com.ExampleforSpringboot.Student;


public class Student {
    private static int  counter = 1;
    private int id;
    private String name;
    private int age;

    public Student(String name, int age){
        this.id = counter++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}