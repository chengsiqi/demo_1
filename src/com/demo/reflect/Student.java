package com.demo.reflect;

/**
 * @author csq
 * @date 2020/4/24 17:33
 * @description
 **/
public class Student {

    private String name;
    private int age;

    private Teacher teacher;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
