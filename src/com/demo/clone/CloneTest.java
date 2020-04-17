package com.demo.clone;

/**
 * @author csq
 * @date 2020/4/10 16:39
 * @description
 *
 * 注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的
 * 对象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object
 * 类的clone方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。
 *
 **/
public class CloneTest {

    public static void main(String[] args){
        try {
            Person p1 = new Person("Hao LUO", 333 , new Car("Benz", 300));
            System.out.println("p1: " + p1);
            // 深度克隆
            Person p2 = MyUtil.clone(p1);
            System.out.println("p2: " + p2);
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            p2.getCar().setBrand("BYD");

            System.out.println("p1: " + p1);
            System.out.println("p2: " + p2);

            /**
             * 匿名内部类在实现时必须借助一个接口或者一个抽象类或者一个普通类来构造,
             * 从这个层次上讲匿名内部类是实现了接口或者继承了类, 但是不能通过extends或implement关键词来继承类或实现接口。
             */
            new Car("hehe", 200){
                public void sysCar() {
                    System.out.println(this.toString());
                }
            }.sysCar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
