package com.demo.assertion;

import org.junit.Test;

/**
 * @author csq
 * @date 2020/4/17 10:50
 * @description
 **/
public class AssertTest {

    @Test
    public void test(){
        /**
         * 断言在软件开发中是一种常用的调试方式, 一般来说, 断言用于保证程序最基本、关键的正确性
         * 断言检查通常在开发和测试时开启。为了保证程序的执行效率, 在软件发布后断言检查通常是关闭的
         * 断言是一个包含布尔表达式的语句, 在执行这个语句是假定该表达式为true；如果表达式的值为false，
         * 那么系统会报告一个AssertionError
         *
         * 注意：断言不应该以任何方式改变程序的状态。简单的说，如果希望在不满足某些条件时阻止代码的执行，就可以考虑用断言来阻止它。
         *
         * 声明断言：assert
         *  assert assertion;
         *  assert assertion : detailMessage;
         *  其中assertion是一个布尔表达式, detailMessage是一个基本类型或者一个对象值
         *
         * 不应该使用断言代替异常处理，异常处理用于在程序运行期间处理非常环境，断言是要确保程序的正确性。
         * 异常处理针对程序的健壮性，而断言设计程序的正确性。与异常处理类似，断言不能代替正常的检验，
         * 只是检测内部的一致性和有效性。断言在运行是检验，可以在程序启动时打开或关闭。
         *
         * 不要使用断言检测public方法的参数。传给public方法的有效参数被认为是方法合约的一部分。
         * 无论断言是否起作用，都必须遵守合约。
         */
        int i;
        int sum = 0;
        // i<100时会抛出异常
        for (i = 0; i < 10; i++){
            // sum+=1 时会抛出异常
            sum += i;
        }
        assert i == 10;
        assert sum > 10 && sum < 5 * 10 : "sum is " + sum;
    }
}
