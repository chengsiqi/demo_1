package com.demo.stringdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author csq
 * @date 2019/9/3 10:27
 * @description
 *
 * String
 * String 声明的字符串, 长度是不可变的 (底层结构是使用final修饰的字符数组, ), 这也是它与StringBuffer 和 StringBuilder最直观的一个区别. 一般初始化方式：String s="hello world",
 * 经过这条语句, JVM的栈内存中产生一个s变量, 堆内存中产生hello world字符串对象。 s指向了hello world对象的地址
 * 像上面这种方式产生的字符串属于直接量字符串对象, JVM在处理这类字符串的时候, 会进行缓存, 产生时放入字符串常量池, 当程序需要再次使用的时候, 无需
 * 重新创建一个新的字符串, 而是直接指向已经存在的字符串
 **/
public class StringDemo {

    public static void main(String[] args){
        String s = "hello world";
        String s1 = "hello world";
        System.out.println(s == s1);

        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");

        ArrayList<String> list1 = new ArrayList<>(list);
        System.out.println(list1);

        HashMap<String, Object> hashMap = new HashMap<>();
    }

    /**
     * indexOf(str) 返回指定子字符串第一次出现的字符串内的索引
     * substring(beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。 子字符串以指定索引处的字符开头，并扩展到该字符串的末尾
     */
    @Test
    public void test(){
        String a = "abcdefgabcd";
        String b = "abc";
        int index = a.indexOf(b);
        System.out.println(index);

        a = a.substring(index + b.length());
        System.out.println(a);
        int index1 = a.indexOf(b);
        System.out.println(index1);
    }
}
