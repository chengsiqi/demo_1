package com.demo.sort;

import java.util.Arrays;

/**
 * 选择排序（Selection Sort）
 * 选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素, 存放到排列序列的起始位置
 * 然后, 再从剩余未排序元素中继续寻找最小（大）元素, 然后放到已排序序列的末尾。以此类推, 直到所有元素均排列完毕
 *
 * 表现最稳定的排序算法之一, 因为无论什么数据进去都是O(n*n)的时间复杂度,所以用到它的时候, 数据规模越小越好。
 * 唯一的好处可能就是不占用额外的内存空间了吧。理论上讲, 选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
 *
 *
 * @author csq
 * @date 2019/9/19 14:21
 * @description
 **/
public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {32,12,23,34,56,42,67,1,23,38,123};

        for (int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j=i+1;j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
