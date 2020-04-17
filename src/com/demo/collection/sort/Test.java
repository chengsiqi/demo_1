package com.demo.collection.sort;

import java.util.*;

/**
 * @author csq
 * @date 2020/4/17 17:01
 * @description
 *
 * TreeSet要求存放的对象所属的类必须实现Comparator接口, 该接口提供了比较元素的compareTo()方法
 * 当插入元素时会回调该方法比较元素的大小。TreeMap要求存放的键值对映射的键必须实现Comparator接口
 * 从而根据键对元素进行排序。
 **/
public class Test {

    public static void main(String [] args){
        System.out.println("TreeSet:");
        Set<Student> set = new TreeSet<>();
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));

        for (Student student : set){
            System.out.println(student);
        }

        System.out.println("ArrayList:");
        List<Student> list = new ArrayList<>();
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));
        Collections.sort(list);
        for (Student student : list){
            System.out.println(student);
        }

    }
}
