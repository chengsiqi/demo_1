package com.demo.exception;

import org.junit.Test;

/**
 * @author csq
 * @date 2020/4/17 11:22
 * @description
 **/

class ExampleA extends Exception{
    public ExampleA() {
    }

    public ExampleA(String message) {
        super(message);
    }
}

class ExampleB extends ExampleA{
    public ExampleB() {
    }

    public ExampleB(String msg) {
        super(msg);
    }
}

public class ExceptionTest {

    @Test
    public void test(){
        try {
            throw new ExampleB("b");
        } catch(ExampleA e){
            System.out.println("ExampleA");
        } catch(Exception e){
            System.out.println("Exception");
        }
    }

    @Test
    public void test1(){
        try {
            try {
                throw new ExampleB();
            } catch ( ExampleA a ) {
                System.out.println("Caught A");
                throw a;
            }
        } catch ( ExampleB b ) {
            System.out.println("Caught B");
            return ;
        } finally {
            System.out.println("Hello World!");
        }
    }
}
