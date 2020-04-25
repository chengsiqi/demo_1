package com.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sort）
 * 冒泡排序是一种简单的排序算法。它重复的走访过要排序的数列,一次比较两个元素, 如果它们的顺序错误就把
 * 它们交换过来。走访数列的工作是重复的进行,直到没有再需要交换, 也就是说该数列已经排序完成。这个算法的名字
 * 由来是因为越小的元素会经由交换慢慢浮到数列的顶端
 *
 * @author csq
 * @date 2019/9/19 10:08
 * @description
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 32, 4, 2, 6, 8, 7, 89, 54, 34, 99};

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                // 相邻元素两两比较
                if (arr[j] > arr[j + 1]) {
                    // 元素交换
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
