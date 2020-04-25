package com.demo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author csq
 * @date 2020/4/25 9:53
 * @description
 *
 * 冒泡排序
 **/
public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++){
            swapped = false;
            for (int j = 0; j < len - i; j++){
                if(list[j].compareTo(list[j + 1]) > 0){
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++){
            swapped = false;
            for (int j = 0; j < len -i; j++){
                if(comp.compare(list[j], list[j + 1]) > 0){
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Test
    public void test(){
        Integer[] arr = {5, 32, 4, 2, 6, 8, 7, 89, 54, 34, 99};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1(){
        Integer[] arr = {5, 32, 4, 2, 6, 8, 7, 89, 54, 34, 99};
        /*sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        });*/

        sort(arr, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(arr));
    }
}
