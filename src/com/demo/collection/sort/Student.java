package com.demo.collection.sort;

/**
 * @author csq
 * @date 2020/4/17 16:58
 * @description
 **/
public class Student implements Comparable<Student> {

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

    @Override
    public int compareTo(Student o) {
        // 比较年龄（年龄的升序）
        return this.age - o.age;
    }
}
