package com.demo.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csq
 * @date 2019/9/24 17:41
 * @description 截取list实现集合分页
 **/
public class SubList {

    public static void main(String[] args) {
        // String[] arg = new String[2];
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        // fromIndex - 含
        // toIndex - 不包含
        // 如果fromIndex和toIndex相等，返回的列表为空
        System.out.println(list.subList(0, 10));

        System.out.println(subList(list, 1, 3));
        System.out.println(subList(list, 2, 3));
        System.out.println(subList(list, 3, 3));
        System.out.println(subList(list, 4, 3));

        //集合分页
        System.out.println(subList1(list, 1, 3));
        System.out.println(subList1(list, 2, 3));
        System.out.println(subList1(list, 3, 3));
        System.out.println(subList1(list, 4, 3));
    }

    private static List subList(List list, int num, int size) {
        List list1;
        if (list.size() > num * size) {
            list1 = list.subList((num - 1) * size, num * size);
        } else {
            list1 = list.subList((num - 1) * size, list.size());
        }
        return list1;
    }

    private static List subList1(List list, int pageNum, int pageSize) {
        List currentPageList = new ArrayList<>();
        // 每页开始索引
        int currIdx = (pageNum > 1 ? (pageNum - 1) * pageSize : 0);
        // 取出每页的数据, pageSize 每页个数
        // i < list.size() - currIdx 防止最后一页超出索引
        for (int i = 0; i < pageSize && i < list.size() - currIdx; i++) {
            currentPageList.add(list.get(currIdx + i));
        }
        return currentPageList;
    }
}
