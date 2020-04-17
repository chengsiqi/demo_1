package com.demo.innerclass;

/**
 * @author csq
 * @date 2020/4/10 10:33
 * @description
 **/
public class PokerTest {

    public static void main (String[] args){
        Poker poker = new Poker();
        // 洗牌
        poker.shuffle();
        // 发第一张牌
        Poker.Card c1 = poker.deal(0);
        // 对于非静态内部类Card
        // 只有通过其外部类Poker对象才能创建Card对象
        Poker.Card c2 = poker.new Card("红心", 1);

        System.out.println(c1);
        System.out.println(c2);

        new PokerTest(){
            @Override
            public void test() {
                System.out.println("hello");
            }
        }.test();
    }

    public void test(){
        System.out.println("hehe");
    }
}
