package com.demo.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author csq
 * @date 2020/4/17 17:08
 * @description
 *
 * Collections工具类的sort方法有两种重载的形式：
 *  第一种要求传入的待排序容器中存放的对象比较实现Comparable接口以实现元素的比较
 *  第二种不强制性的要求容器中的元素必须课比较, 但是要求传入第二个参数, 参数是
 *  Comparator接口的子类型（要求重写compare方法实现元素的比较）,相当于一个临时定义
 *  的排序规则, 其实就是通过接口注入比较元素大小的算法, 也是对回调函数的应用（Java中对函数式编程的支持）。
 **/
public class Test1 {

    public static void main(String[] args){
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Hao LUO", 33));
        list.add(new Student1("XJ WANG", 32));
        list.add(new Student1("Bruce LEE", 60));
        list.add(new Student1("Bob YANG", 22));

        Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());

        /*Collections.sort(list, new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                // 比较学生姓名
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        for (Student1 student1 : list){
            System.out.println(student1);
        }
    }
}
