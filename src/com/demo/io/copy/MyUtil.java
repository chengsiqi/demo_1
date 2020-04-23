package com.demo.io.copy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author csq
 * @date 2020/4/22 15:57
 * @description
 *
 * Java中有几种类型的流
 * 答：字节流和字符流。 字节流继承与InputStream、OutputStream,字符流继承与Reader、Writer
 * 在java.io包中还有许多其他的流, 主要是为了提高性能和使用方便。
 *
 * 关于Java的I/O需要注意的有两点：
 *  一是两种对称性(输入和输出的对称性, 字节和字符的对称性)
 *  二是两种设计模式(适配器模式和装潢模式)
 *
 * 面试题 - 编程实现文件拷贝。（这个题目在笔试的时候经常出现，下面的代码给出了两种实现方案）
 **/
public class MyUtil {

    public MyUtil() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (OutputStream os = new FileOutputStream(target);
             InputStream is = new FileInputStream(source)){
            byte[] buffer = new byte[4096];
            int bytesToRead;
            while ((bytesToRead = is.read(buffer)) != -1){
                os.write(buffer, 0, bytesToRead);
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(target);
             FileInputStream fis = new FileInputStream(source)){
            FileChannel fisChannel = fis.getChannel();
            FileChannel fosChannel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            while (fisChannel.read(buffer) != -1){
                // 反转此缓冲区, 设置当前位置指针为0,read读文件后文件指针在缓冲区末尾, 需要使用flip重置
                buffer.flip();
                fosChannel.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // MyUtil.fileCopy("G:\\jar\\yryj-oms.jar", "G:\\jar\\temp.jar");
        MyUtil.fileCopyNIO("G:\\jar\\yryj-oms.jar", "G:\\jar\\temp.jar");
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start));
    }

    // 注意：上面用到Java7的TWR(Try-with-resources)，使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅。

    // try-with-resources语句是声明了一个或多个资源的try语句块。
    // 在java中资源作为一个对象，在程序完成后必须关闭。try-with-resources语句确保每个资源在语句结束时关闭。
    // 只要是实现了java.lang.AutoCloseable的任何对象
    // （包括实现java.lang.Closeable的所有对象）都可以使用该方式对资源进行关闭。
}
