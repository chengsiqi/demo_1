package com.demo.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列, 对于未排序数据, 在已排序序列
 * 中从后向前扫描, 找到相应位置并插入。
 *
 * @author csq
 * @date 2019/9/19 15:11
 * @description
 **/
public class InsertionSort {

    public static void main(String[] args){
        int[] arr = {23,12,234,35,67,894,5,45,23,57,32,56};
        //Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (int i=1; i< arr.length; i++){
            int preIndex = i-1;
            int current = arr[i];
            while(preIndex >=0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }

        System.out.println(Arrays.toString(arr));
    }
}
