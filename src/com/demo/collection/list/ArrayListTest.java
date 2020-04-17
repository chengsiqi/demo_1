package com.demo.collection.list;

/**
 * @author csq
 * @date 2020/4/17 15:44
 * @description
 *
 * ArrayList和Vector都是使用数组方式存储数据, 此数组元素数大于实际存储的数据以便增加和插入元素, 它们都允许
 * 直接按序号索引元素, 但是插入元素要涉及数组元素移动等内存操作, 所以索引数据块而插入数据慢, Vector中的方法
 * 由于添加了synchronized修饰, 因此Vector是线程安全的容器, 但性能上较ArrayList差, 因此已经是Java中的遗留容器
 *
 * LinkedList使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来, 形成一个可以按序号索引的线性结构, 这种
 * 链式存储方式与数组的连续存储方式相比, 内存的利用率更高）, 按序号索引数据需要进行前向或者后向遍历, 但是插入数据时
 * 只需要记录本项的前后项即可, 所以插入速度较快
 *
 * Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、
 * Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到
 * 多个线程操作同一个容器的场景, 则可以通过工具类Collections中的synchronizedList方法将其转换成线程安全
 * 的容器后在使用（这是对装潢模式的应用, 将已有对象传入另一个类的构造器中创建新的对象来增强实现）
 *
 * 补充：遗留容器中的Properties类和Stack类在设计上有严重的问题，Properties是一个键和值都是字符串的特殊的键值对映射
 * ，在设计上应该是关联一个Hashtable并将其两个泛型参数设置为String类型，但是Java API中的Properties直接继承了Hashtable
 * ，这很明显是对继承的滥用。这里复用代码的方式应该是Has-A关系而不是Is-A关系，另一方面容器都属于工具类，继承工具类本身
 * 就是一个错误的做法，使用工具类最好的方式是Has-A关系（关联）或Use-A关系（依赖）。同理，Stack类继承Vector也是不正确的。
 **/
public class ArrayListTest {
}
