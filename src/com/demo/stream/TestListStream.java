package com.demo.stream;

import com.demo.stream.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 程思琦
 * @date 2019/7/29 9:06
 * @description
 **/
public class TestListStream {

    public static void main(String[] args){
        List<Person> list = new ArrayList<>();

        Person p1 = new Person("a",10,"aaaaa");
        Person p2 = new Person("b",22,"bbbbb");
        Person p3 = new Person("c",33,"ccccc");
        Person p4 = new Person("d",44,"ddddd");
        Person p5 = new Person("e",55,"eeeee");

        list = Arrays.asList(p1,p2,p3,p4,p5);

        filterTest(list);
        mapTest(list);
        flatMapTest(list);
    }

    private static void flatMapTest(List<Person> list){
        List<String> list1 = list.stream().flatMap(new Function<Person, Stream<String>>() {
            @Override
              public Stream<String> apply(Person person) {
                return Arrays.stream(person.getName().split(""));
            }
        }).collect(Collectors.toList());
        System.out.println("list1:" + list1);

        List<Stream<String>> list2 = list.stream().map(new Function<Person, Stream<String>>() {
            @Override
            public Stream<String> apply(Person person) {
                return Arrays.stream(person.getName().split(""));
            }
        }).collect(Collectors.toList());
        System.out.println("list2:" + list2);

        List<String> list3 = list.stream().map(person -> person.getName().split(""))
                .flatMap(strings -> Arrays.asList(strings).stream())
                .collect(Collectors.toList());
        System.out.println("list3:" + list3);
    }

    /**
     * filter age > 13 and name = d
     * @author 程思琦
     * @date 9:27 2019/7/29
     * @param
     * @return
     */
    private static void filterTest(List<Person> list) {
        List<Person> list1 = new ArrayList<>();
        for (Person p : list){
            if (p.getAge() >13 && p.getName().equals("d")){
                list1.add(p);
            }
        }
        println(list1);

        List<Person> list2 = list.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                if(p.getAge() >13 && p.getName().equals("d")){
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
        println(list2);

        List<Person> list3 = list.stream().filter(person ->
                (person.getAge()>13 && person.getName().equals("d")))
                .collect(Collectors.toList());
        println(list3);

        List<Person> list4 = list.stream().filter(person ->
            {
                if(person.getAge()>13 && person.getName().equals("d")){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        println(list4);
    }

    /**
     * @author 程思琦
     * map
     * @date 10:06 2019/7/29
     * @param
     * @return
     */
    private static void mapTest(List<Person> list){
        List<String> list1 = list.stream().map(new Function<Person, String>() {

            @Override
            public String apply(Person person) {
                return person.getName();
            }
        }).collect(Collectors.toList());
        System.out.println("list1:" + list1);

        List<String> list2 = list.stream().map(person -> person.getName())
                .collect(Collectors.toList());
        System.out.println("list2:" + list2);

        List<String> list3 = list.stream().map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("list3:" + list3);
    }

    private static void println(List<Person> list){
        for (Person p : list){
            System.out.println(p.toString());
        }
    }
}
