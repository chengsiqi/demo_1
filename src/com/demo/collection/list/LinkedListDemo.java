package com.demo.collection.list;

import java.util.LinkedList;

/**
 * @author csq
 * @date 2019/10/8 10:52
 * @description
 **/
public class LinkedListDemo {

    public static void main(String[] args){
        // 创建存放int类型的 LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();

        /*******************LinkedList基本操作*******************/
        // 添加元素到列表开头
        linkedList.addFirst(0);
        // 在列表结尾添加元素
        linkedList.add(1);
        // 在指定位置添加元素
        linkedList.add(2,2);
        // 添加元素到列表结尾
        linkedList.addLast(3);
        System.out.println("LinkedList:"+ linkedList);

        System.out.println("getFirst()获得第一个元素:" + linkedList.getFirst());
        System.out.println("getLast()获得最后一个元素:" + linkedList.getLast());
        System.out.println("removeFirst()删除第一个元素并返回:" + linkedList.removeFirst());
        System.out.println("removeLast()删除最后一个元素并返回:" + linkedList.removeLast());
        System.out.println("After remove:" + linkedList);
        System.out.println("contains()方法判断列表是否包含1这个元素：" + linkedList.contains(1));
        System.out.println("该LinkedList的大小：" + linkedList.size());

        /*******************位置访问操作*******************/
        System.out.println("-----------------------------");
        // 将此列表中指定位置的元素替换为指定的元素
        linkedList.set(1,3);
        System.out.println("LinkedList:" + linkedList);
        System.out.println("After set(1,3):" + linkedList);
        System.out.println("get(1)获得指定位置（这里为3）的元素：" + linkedList.get(1));

        /*******************Search操作*******************/
        System.out.println("-----------------------------");
        linkedList.add(3);
        System.out.println("LinkedList:" + linkedList);
        // 返回此列表中首次出现的指定元素的索引
        System.out.println("indexOf(3):" + linkedList.indexOf(3));
        // 返回此列表中最后出现的指定元素的索引
        System.out.println("lastIndexOf(3):" + linkedList.lastIndexOf(3));

        /*******************Queue操作*******************/
        System.out.println("----------------------------");
        System.out.println("LinkedList:" + linkedList);
        // 获取但不移除此列表的头
        System.out.println("peek():" + linkedList.peek());
        // 获取但不一次此列表的头
        System.out.println("element():" + linkedList.element());
        // 获取并移除此列表的头
        linkedList.poll();
        System.out.println("After poll():" + linkedList);
        // 获取并移除此列表的头
        linkedList.remove();
        System.out.println("After remove():" + linkedList);
        // 将指定元素添加到此列表的末尾
        linkedList.offer(4);
        System.out.println("After offer(4):" + linkedList);

        /*******************Deque操作*******************/
        System.out.println("----------------------------");
        System.out.println("LinkedList:" + linkedList);
        // 在此列表的开头插入指定的元素
        linkedList.offerFirst(2);
        System.out.println("After offerFirst(2):" + linkedList);
        // 在此列表的末尾插入指定的元素
        linkedList.offerLast(5);
        System.out.println("After offerLast(5):" + linkedList);
        // 获取但不移除此列表的第一个元素
        System.out.println("peekFirst():" + linkedList.peekFirst());
        // 获取但不移除此列表的最后一个元素
        System.out.println("peekLast():" + linkedList.peekLast());
    }

}
