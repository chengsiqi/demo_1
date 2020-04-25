package com.demo.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author csq
 * @date 2020/4/25 16:35
 * @description
 *
 * 用Java写一个折半查找。
 * 答：折半查找，也称二分查找、二分搜索，是一种在有序数组中查找某一特定元素的搜索算法。
 * 搜素过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜素过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟
 * 开始一样从中间元素开始比较。如果在某一步骤数组已经为空，则表示找不到指定的元素。这种搜索
 * 算法每一次比较都使搜索范围缩小一半，其时间复杂度是O(logN)。
 **/
public class BinarySearch {

    // 使用循环实现的二分查找
    public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else if (key.compareTo(x[mid]) > 0) {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }

    @Test
    public void test() {
        Integer[] arr = {5, 32, 4, 2, 6, 8, 7, 89, 54, 34};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int index = binarySearch(arr, 5, (o1, o2) -> o1 - o2);
        System.out.println("index: " + index);

        int i = binarySearch(arr, 8);
        System.out.println("i: " + i);
    }

    // 说明：上面的代码中给出了折半查找的两个版本，一个用递归实现，一个用循环实现。
    // 需要注意的是计算中间位置时不应该使用(high+ low) / 2的方式，因为加法运算可能导致整数越界，
    // 这里应该使用以下三种方式之一：low + (high - low) / 2或low + (high – low) >> 1或(low + high) >>> 1（>>>是逻辑右移，是不带符号位的右移）

    @Test
    public void test1() {
        /**
         * 为什么使用low + (high - low) / 2而不使用(high + low) / 2呢？目的是防止溢出！
         *
         * 在Java运算中不支持无符号整数，所以我们一般选择low + (high - low) / 2来防止溢出，
         * 但有一种是这样写的low + (high - low) >>> 1，在Java中>>>和>>的区别，则在于无符号和有符号。
         * 如果使用>>，会将符号位也参与运算。
         */

        // int数据类型是32位、有符号的以二进制补码表示的整数
        // 最小值：-2,147,483,648 (-2^31)
        // 最大值：2,147,483,647 (2^31 - 1)

        // 1073741824 = 0100 0000 0000 0000 0000 0000 0000 0000
        int high = 1073741824;
        int low = 1073741824;

        // 作为带符号的32位整数，它是溢出的并且翻转为负。因此(high + low) / 2是错误的，
        // 因为high + low的运算结果可能超出当前类型所表示的范围的。
        System.out.println((high + low) / 2);  // -1073741824
        System.out.println((high + low) >> 1);  // -1073741824

        System.out.println(low + ((high - low) / 2)); // 1073741824
        System.out.println(low + ((high - low) >> 1)); // 1073741824
        System.out.println((high + low) >>> 1); // 1073741824
    }
}
