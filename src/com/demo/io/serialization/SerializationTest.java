package com.demo.io.serialization;

import java.io.*;

/**
 * @author csq
 * @date 2020/4/22 15:11
 * @description
 *
 * Java中如何实现序列化, 有什么意义？
 * 答：序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。
 * 可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。
 * 序列化是为了解决对象流读写操作时可能引发的问题（如果不进行序列化可能会存在数据乱序的问题）。
 *
 * 要实现序列化，需要让一个类实现Serializable接口，该接口是一个标识性接口，标注该类对象
 * 是可被序列化的，然后使用一个输出流来构造一个对象输出流并通过writeObject(Object)方法
 * 就可以将实现对象写出（即保存其状态）；如果需要反序列化则可以用一个输入流建立对象输入流，
 * 然后通过readObject方法从流中读取对象。
 *
 * 序列化除了能够实现对象的持久化之外，还能够用于对象的深度克隆
 **/
public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Student student = new Student("abc", 12);
        write(student);*/

        /*Student student = read();
        System.out.println(student);*/
    }

    public static <T extends Serializable > void write(T obj) throws IOException {
        File file = new File("G:\\jar\\a.txt");
        if(file.exists()){
            file.delete();
        }
        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    public static Student read() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("G:\\jar\\a.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return (Student)object;
    }
}
