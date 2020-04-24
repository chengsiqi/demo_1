package com.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author csq
 * @date 2020/4/24 16:46
 * @description
 *
 * 1、获得一个类的类对象有哪些方式？
 * 答：
 * - 方法1：类型.class，例如：String.class
 * - 方法2：对象.getClass()，例如："hello".getClass()
 * - 方法3：Class.forName()，例如：Class.forName("java.lang.String")
 *
 * 2、如何通过反射创建对象？
 * 答：
 * - 方法1：通过类对象调用newInstance()方法，例如：String.class.newInstance()
 * - 方法2：通过类对象的getConstructor()或getDeclaredConstructor()方法获得构造器（Constructor）对象
 *         并调用其newInstance()方法创建对象，例如：String.class.getConstructor(String.class).newInstance("Hello");
 *
 * 3、如何通过反射获取和设置对象私有字段的值？
 * 答：可以通过类对象的getDeclaredField()方法字段（Field）对象，然后再通过字段对象的setAccessible(true)将其设置为可以访问，
 * 接下来就可以通过get/set方法来获取/设置字段的值了。
 *
 * 下面的代码实现了一个反射的工具类，其中的两个静态方法分别用于获取和设置私有字段的值，字段可以是基本类型也可以是对象类型且支持多级对象操作，
 * 例如ReflectionUtil.get(dog, "owner.car.engine.id");可以获得dog对象的主人的汽车的引擎的ID号。
 *
 **/
public class ReflectionUtil {

    public ReflectionUtil(){
         // throw new AssertionError();
    }

    /**
     * 通过反射取对象指定字段(属性)的值
     *
     * @param target 目标对象
     * @param fieldName 字段的名称
     * @throws 如果取不到对象指定字段的值则抛出异常
     * @return 字段的值
     */
    public static Object getValue(Object target, String fieldName){
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");

        try {
            for (int i = 0; i < fs.length - 1; i++){
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                target = f.get(target);
                clazz = target.getClass();
            }

            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            return f.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过反射给对象的指定字段赋值
     *
     * @param target 目标对象
     * @param fieldName 字段的名称
     * @param value 值
     */
    public static void setValue(Object target, String fieldName, Object value){
        Class<?> clazz = target.getClass();
        String[] fs = fieldName.split("\\.");

        try {
            for (int i = 0; i < fs.length - 1; i++){
                Field f = clazz.getDeclaredField(fs[i]);
                f.setAccessible(true);
                Object val = f.get(target);
                if(val == null){
                    Constructor<?> c = f.getType().getDeclaredConstructor();
                    c.setAccessible(true);
                    val = c.newInstance();
                    f.set(target, val);
                }
                target = val;
                clazz = target.getClass();
            }

            Field f = clazz.getDeclaredField(fs[fs.length - 1]);
            f.setAccessible(true);
            f.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test(){
        Student student = new Student("haha", 12);
        System.out.println(student);
        Object age = getValue(student, "name");
        System.out.println(age);

        setValue(student, "teacher.name", "teacher");
        setValue(student, "teacher.age", 18);
        System.out.println(student);
    }

    /**
     * 通过反射调用对象的方法
     */
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        Method method = str.getClass().getMethod("toUpperCase");
        System.out.println(method.invoke(str));
    }
}
