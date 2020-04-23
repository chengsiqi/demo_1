package com.demo.io;

import org.junit.Test;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

/**
 * @author csq
 * @date 2020/4/22 16:36
 * @description
 *
 * I/O流的一些使用
 *
 **/
public class MyUtil {

    // 工具类中的方法都是静态方式访问的, 因此将构造器私有不允许创建对象(绝对好习惯)
    public MyUtil() {
        // throw new AssertionError();
    }

    // 写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
    /**
     * 统计给定文件中给定字符串的出现次数
     *
     * @param file 文件
     * @param word 字符串
     * @return 字符串在文件中出现的次数
     */
    public static int countWordInFile(String file, String word){
        int counter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            while ((line = br.readLine()) != null){
                int index = -1;
                while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
                    counter++;
                    line = line.substring(index + word.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    @Test
    public void countWordInFileTest(){
        int count = countWordInFile("G:\\jar\\a.txt", "abc");
        System.out.println(count);
    }

    /**
     * 列出当前文件夹下的文件
     */
    @Test
    public void test(){
        File f = new File("g:/jar");
        for (File temp : f.listFiles()){
            if(temp.isFile()){
                System.out.println(temp.getName());
            }
        }
    }

    /**
     * 列出当前文件夹下的所有文件(包括该文件夹下子文件夹里的所有文件)
     */
    @Test
    public void test1(){
        File f = new File("g:/jar");
        _walkDirectory(f, 0);
    }

    public void _walkDirectory(File f, int level){
        if(f.isDirectory()){
            for (File temp : f.listFiles()){
                _walkDirectory(temp, level + 1);
            }
        }else {
            for (int i = 0; i < level - 1; i++){
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }

    /**
     * 列出当前文件夹下的所有文件(包括该文件夹下子文件夹里的所有文件)
     *
     * 在Java 7中可以使用NIO.2的API来做同样的事情，代码如下所示：
     */
    @Test
    public void test2() throws IOException {
        Path path = Paths.get("g:/jar");
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });

    }
}
