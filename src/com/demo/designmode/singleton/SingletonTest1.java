package com.demo.designmode.singleton;

/**
 * @author csq
 * @date 2020/4/25 9:39
 * @description
 *
 * 懒汉式单例
 **/
public class SingletonTest1 {

    private SingletonTest1() {
    }

    private static SingletonTest1 instance = null;

    public static SingletonTest1 getInstance(){
        if(instance == null){
            return new SingletonTest1();
        }
        return instance;
    }
}
