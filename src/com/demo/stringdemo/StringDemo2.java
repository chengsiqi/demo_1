package com.demo.stringdemo;

import org.junit.Test;

import java.io.Console;
import java.io.UnsupportedEncodingException;

/**
 * @author csq
 * @date 2020/4/9 9:46
 * @description
 **/
public class StringDemo2 {

    public static void main(String[] args){
        String s1 = new StringBuilder("go").append("od").toString();
        System.out.println(s1.intern() == s1);
        String s11 = new StringBuilder("good").toString();
        System.out.println(s11.intern() == s11);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
        String s3 = "java";
        System.out.println(s2.intern() == s3);
        System.out.println(s2 == s3);
        /**
         * 关于《深入理解Java虚拟机》第2章的问题
         *
         * 作者指出由于JDK1.7开始逐步“去永久代”，所以如果JDK1.6会返回两个false, JDK1.7运行则会返回一个true一个false
         *
         * 因为JDK1.6中, intern()方法会把首次遇到的字符串实例复制到永久代中, 返回的也是永久代中这个字符串的实例的引用,
         * 而StringBuilder创建的字符串实例在Java堆上, 所以必然不是同一个引用, 将返回false
         *
         * 在JDK1.7中, intern()的实现不会再复制实例, 只是在常量池中记录首次出现的实例引用, 因此返回时的引用和由
         * StringBuilder.toString()创建的那个字符串实例是同一个
         *
         * s2的比较返回false, 因为“java”这个字符串在执行StringBuilder.toString()之前已经出现过, 字符串常量池中已经有它的引用了,
         * 不符合“首次出现”的原则, 而“good”这个字符串是首次出现, 因此返回true
         *
         * "java"字符串在 System类初始化加载的时候加入常量池 (sun.misc.Version类中)
         */
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

    @Test
    public void test1(){
        String str = "hello";
        // beginIndex -- 起始索引（包括）, 索引从 0 开始。
        // endIndex -- 结束索引（不包括）。
        System.out.println(str.substring(1, 3));

        String reverseStr = reverse(str);
        System.out.println(reverseStr);
        System.out.println(new StringBuilder(str).reverse());

        String str1 = "0";
        System.out.println(str1.substring(1));
    }

    /**
     * 递归实现字符串反转
     */
    public String reverse(String originStr){
        if(originStr == null || originStr.length() <= 1){
            return originStr;
        }
        // charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    @Test
    public void test2(){
        Integer i1 = 100;
        String s1 = String.valueOf(i1);

        Integer i2 = Integer.valueOf(10);
        System.out.println(i2);
    }
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "你好";
        // String(byte[] bytes, Charset charset): 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
        // getBytes(String charsetName):使用指定的字符集将字符串编码为 byte 序列，并将结果存储到新的 byte 数组中
        String s2 = new String(str.getBytes("GB2312"), "iso-8859-1");
        System.out.println(s2);
        String s3 = new String(s2.getBytes("iso-8859-1"), "GB2312");
        System.out.println(s3);

        byte[] strBytes = str.getBytes();
        String s = new String(strBytes, "utf-8");
        System.out.println(s);
    }
}
