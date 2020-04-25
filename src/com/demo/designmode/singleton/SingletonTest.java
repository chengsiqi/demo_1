package com.demo.designmode.singleton;

/**
 * @author csq
 * @date 2020/4/25 9:36
 * @description
 *
 * 饿汉式单例
 **/
public class SingletonTest {

    private static SingletonTest instance = new SingletonTest();

    private SingletonTest() {
    }

    public static SingletonTest getInstance(){
        return instance;
    }

    // 注意：实现一个单例有两点注意事项，
    // ①将构造器私有，不允许外界通过构造器创建对象；
    // ②通过公开的静态方法向外界返回类的唯一实例。
    // 这里有一个问题可以思考：Spring的IoC容器可以为普通的类创建单例，它是怎么做到的呢？
}
