package com.demo.xml;

/**
 * @author csq
 * @date 2020/4/23 17:36
 * @description
 *
 * 1、XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式？
 *
 * 答：XML文档定义分为DTD和Schema两种形式，二者都是对XML语法的约束，其本质区别在于Schema本身
 * 也是一个XML文件，可以被XML解析器解析，而且可以为XML承载的数据定义类型，约束能力较之DTD更强大。
 * 对XML的解析主要有DOM（文档对象模型，Document Object Model）、SAX（Simple API for XML）
 * 和StAX（Java 6中引入的新的解析XML的方式，Streaming API for XML），其中DOM处理大型文件时
 * 其性能下降的非常厉害，这个问题是由DOM树结构占用的内存较多造成的，而且DOM解析方式必须在解析文件之
 * 前把整个文档装入内存，适合对XML的随机访问（典型的用空间换取时间的策略）；SAX是事件驱动型的XML解
 * 析方式，它顺序读取XML文件，不需要一次全部装载整个文件。当遇到像文件开头，文档结束，或者标签开头与
 * 标签结束时，它会触发一个事件，用户通过事件回调代码来处理XML文件，适合对XML的顺序访问；
 * 顾名思义，StAX把重点放在流上，实际上StAX与其他解析方式的本质区别就在于应用程序能够把XML作为一个
 * 事件流来处理。将XML作为一组事件来处理的想法并不新颖（SAX就是这样做的），但不同之处在于StAX允许
 * 应用程序代码把这些事件逐个拉出来，而不用提供在解析器方便时从解析器中接收事件的处理程序。
 *
 * 2、你在项目中哪些地方用到了XML？
 *
 * 答：XML的主要作用有两个方面：数据交换和信息配置。
 * 在做数据交换时，XML将数据用标签组装成起来，然后压缩打包加密后通过网络传送给接收者，接收解密与解压
 * 缩后再从XML文件中还原相关信息进行处理，XML曾经是异构系统间交换数据的事实标准，但此项功能几乎已经
 * 被JSON（JavaScript Object Notation）取而代之。当然，目前很多软件仍然使用XML来存储配置信息，
 * 我们在很多项目中通常也会将作为配置信息的硬代码写在XML文件中，Java的很多框架也是这么做的，而且这
 * 些框架都选择了dom4j作为处理XML的工具，因为Sun公司的官方API实在不怎么好用。
 *
 *
 * 补充：现在有很多时髦的软件（如Sublime）已经开始将配置文件书写成JSON格式，我们已经强烈的感受到
 * XML的另一项功能也将逐渐被业界抛弃。
 *
 **/
public class Xml {
}