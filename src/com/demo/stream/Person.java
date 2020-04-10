package com.demo.stream;

/**
 * @author 程思琦
 * @date 2019/7/29 9:02
 * @description
 **/
public class Person {
    private String name;
    private int age;
    private String province;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Person(String name, int age, String province) {
        this.name = name;
        this.age = age;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", province='" + province + '\'' +
                '}';
    }
}
