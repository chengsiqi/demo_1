package com.demo.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author csq
 * @date 2019/10/7 11:37
 * @description
 **/
public class HashMapDemo {

    public static void main(String[] args){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",1);
        hashMap.put("5",1);
        hashMap.put("6",1);
        hashMap.put("7",1);
        hashMap.put("8",1);
        hashMap.put("9",1);
        hashMap.put("10",1);
        hashMap.put("11",1);
        hashMap.put("12",1);
        hashMap.put("13",1);
        System.out.println(hashMap);

        HashMap<String, String> map = new HashMap<>();
        // 键不能重复 值可以重复
        map.put("san","张三");
        map.put("si","思丽思 ");
        System.out.println("----直接输出HashMap----");
        System.out.println(map);

        /**
         * 遍历 HashMap
         */
        // 1.获取Map中的所有键
        System.out.println("----foreach获取Map中所有的键----");
        Set<String> keys = map.keySet();
        for (String key : keys){
            System.out.println(key);
        }
        System.out.println();

        // 2.获取Map中的所有值
        System.out.println("-                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ---foreach获取Map中所有的值----");
        Collection<String> values = map.values();
        for (String value : values){
            System.out.println(value);
        }
        System.out.println();

        // 3.得到key的值 同时得到key所对应的值
        System.out.println("----得到key的值 同时得到key对应的值----");
        Set<String> keys2 = map.keySet();
        for (String key : keys2){
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println();

        /**
         * 另外一种不常用的遍历方式
         */
        // 当我调用 put(key,value)方法的时候, 首先会把key和value封装到
        // Entry这个静态内部类对象中, 把Entry对象再添加到数组中, 所以我们想获取
        // map中的所有键值对, 我们只要获取数组中的所有Entry对象, 接下来
        // 调用Entry对象中的getKey()和getValue()方法就能获取键值对了
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();

        /**
         * HashMap 其它常用方法
         */
        System.out.println("after map.size():" + map.size());
        System.out.println("after map.isEmpty():"+map.isEmpty());
        System.out.println(map.remove("san"));
        System.out.println("after map.remove():"+ map);
        System.out.println("after map.get(si):"+map.get("si"));
        System.out.println("after map.containsKey(si):"+map.containsKey("si"));
        System.out.println("after map.containsValue(李四):" + map.containsValue("李四"));
        System.out.println(map.replace("si","李四2"));
        System.out.println("after map.replace(si)" + map);
    }
}
