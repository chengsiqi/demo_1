package com.demo.exception;

/**
 * @author csq
 * @date 2020/4/17 11:33
 * @description
 **/

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {

    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch ( Annoyance a ) { // 我们可以用父类的引用接受子类的异常对象
                System.out.println("Caught Annoyance");
                // 这一句使用的是父类的引用，但实际上是子类的对象，这是java中多态的经典表现
                throw a;
                // throw new Annoyance();
            }
        } catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        } finally {
            System.out.println("Hello World!");
        }

        // Caught Annoyance
        // Caught Sneeze
        // Hello World!
    }
}
