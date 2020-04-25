package com.demo;

import org.junit.Test;

public class Main {

    public static void main(String[] args) {
        /* 60 = 0011 1100 */
        /* 13 = 0000 1101 */
        int A = 60;
        int B = 13;
        System.out.println( "A&B=" + (A&B) );
        System.out.println( "A|B=" + (A|B) );
        System.out.println( "~A=" + (~A) );
        System.out.println( "~B=" + (~B) );

        System.out.println( "A^B=" + (A^B) );
        System.out.println( "A<<2=" + (A<<2) );
        System.out.println( "A>>2=" + (A>>2) );
        System.out.println( "A>>>2=" + (A>>>2) );


        System.out.println( "-4<<2=" + (-4<<2) );

        System.out.println("5/2=" + (5/2));
    }
}
