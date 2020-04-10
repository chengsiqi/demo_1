package com.demo.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author csq
 * @date 2019/9/2 17:19
 * @description
 *
 * Comparator(比较器)和Comparable(可比较的)的区别
 * 一个类实现了Comparable接口则表明这个类的对象之间是可以相互比较的, 这个类对象组成的集合就可以直接使用sort方法排序
 *
 * Comparator(比较器)可以看成一种算法的实现, 将算法和数据分离, Comparator也可以在下面两种环境下使用：
 * 1、类的设计师没有考虑到比较问题而没有实现Comparable, 可以通过Comparator来实现排序而不必改变对象本身
 * 2、可以使用多种排序标准, 比如升序、降序等
 *
 *
 *
 **/
public class UserComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((User)o1).getAge() - ((User)o2).getAge();
    }

    public static void main(String[] args){
        User[] users = new User[]{new User("a",30), new User("b",20)};

        // Arrays.sort(users);
        Arrays.sort(users, new UserComparator());

        for (int i=0;i<users.length; i++){
            User user = users[i];
            System.out.println(user.getId()+" "+user.getAge());
        }
    }
}
