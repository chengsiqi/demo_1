package com.demo.io.serialization;

import java.io.Serializable;

/**
 * @author csq
 * @date 2020/4/22 15:12
 * @description
 **/
public class Student implements Serializable {

    private static final long serialVersionUID = 9072366510673482455L;

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
