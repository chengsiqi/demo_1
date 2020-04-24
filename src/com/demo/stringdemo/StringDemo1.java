package com.demo.stringdemo;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author csq
 * @date 2020/4/24 16:36
 * @description
 *
 * Java中是如何支持正则表达式操作的？
 * 答：Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。
 * 此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作
 *
 **/
public class StringDemo1 {

    /**
     * 面试题： - 如果要从字符串中截取第一个英文左括号之前的字符串，
     *          例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？
     */
    @Test
    public void test(){
        String Str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern pattern = Pattern.compile(".*?(?=\\()");
        Matcher m = pattern.matcher(Str);
        if(m.find()){
            System.out.println(m.group());
        }
    }
}
