package com.demo.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 当需要排序的集合或数组不是单纯的数字型时, 通常可以使用Comparator或Comparable, 以简单的方式实现对象排序或自定义排序
 *
 * @author csq
 * @date 2019/9/2 14:37
 * @description
 *
 * 强行对某个对象collection进行整体排序的比较函数，可以将Comparator传递给Collections.sort或Arrays.sort。
 *
 **/
public class SampleComparator implements Comparator {


    /**
     * o1 小于、等于或大于 o2, 分别返回负整数、零或正整数
     */
    @Override
    public int compare(Object o1, Object o2) {
        return toInt(o1)-toInt(o2);
    }

    private int toInt(Object o){
        String str = (String) o;
        str = str.replaceAll("一", "1");
        str = str.replaceAll("二", "2");
        str = str.replaceAll("三", "3");
        return Integer.parseInt(str);
    }

    public static void main(String[] args){
        String[] array = new String[]{"一二","三","二"};
        Arrays.sort(array, new SampleComparator());
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
