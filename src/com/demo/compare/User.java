package com.demo.compare;

import java.util.Arrays;

/**
 * @author csq
 * @date 2019/9/2 16:58
 * @description
 *
 * Comparable
 *
 * 强行对实现他的每个类的对象进行整体排序, 实现此接口的对象列表(和数组)可以通过Collections.sort或 Arrays.sort进行自动排序
 **/
public class User implements Comparable {

    private String id;
    private int age;

    public User(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 该对象小于、等于或大于指定对象o , 分别返回负整数、零或正整数
     */
    @Override
    public int compareTo(Object o) {
        return this.age - ((User)o).getAge();
    }

    public static void main(String[] args){
        User[] users = new User[]{new User("a",30), new User("b",20)};

        Arrays.sort(users);

        for (int i=0;i<users.length; i++){
            User user = users[i];
            System.out.println(user.getId()+" "+user.getAge());
        }
    }
}
