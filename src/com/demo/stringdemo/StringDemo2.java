package com.demo.stringdemo;

import org.junit.Test;

import java.io.Console;

/**
 * @author csq
 * @date 2020/4/9 9:46
 * @description
 **/
public class StringDemo2 {

    public static void main(String[] args){
        // String s1 = new StringBuilder("go").append("od").toString();
        String s1 = new StringBuilder("good").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        String s3 = "java";
        System.out.println(s2.intern() == s3);
        System.out.println(s2 == s3);
    }

    @Test
    public void test(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        String s7 = s3 + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s7);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

}
