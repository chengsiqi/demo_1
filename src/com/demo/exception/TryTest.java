package com.demo.exception;

/**
 * 问： try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?
 * 答：会执行，在方法返回调用者前执行。
 *
 * 注意：在finally中改变返回值的做法是不好的，因为如果存在finally代码块，try中的return语句不会立马返回调用者，而是记录下返回值
 * 待finally代码块执行完毕之后再向调用者返回其值，然后如果在finally中修改了返回值，就会返回修改后的值。
 *
 * 显然，在finally中返回或者修改返回值会对程序造成很大的困扰，C#中直接用编译错误的方式来阻止程序员干这种龌龊的事情，Java中也可以通过
 * 提升编译器的语法检查级别来产生警告或错误，强烈建议将此项设置为编译错误。
 */
public class TryTest  {

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args){
        //try
        //finally
        //try return
        // 将finally中的return去掉，打印结果如上
        System.out.print(tryTest());
        // try
        //finally
        //finally return
        // 将finally中的return加上，打印结果如上
    }

    public static String tryTest(){
        String str = "";
        try {
            System.out.println("try");
            str = "try return ";
            return str;
        }catch (Exception e){
            System.out.println("catch");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
            str = "finally return";
            // return str;
        }
        return "return";
    }
}
