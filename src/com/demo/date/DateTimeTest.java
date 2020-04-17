package com.demo.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author csq
 * @date 2020/4/11 10:35
 * @description
 **/
public class DateTimeTest {

    /**
     * 获取年月日时分秒
     */
    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        // 年
        System.out.println(calendar.get(Calendar.YEAR));
        // 月
        System.out.println(calendar.get(Calendar.MONTH));
        // 日
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        // 时
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        // 分
        System.out.println(calendar.get(Calendar.MINUTE));
        // 秒
        System.out.println(calendar.get(Calendar.SECOND));

        // java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonth());
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
    }

    /**
     * 如何取得从1970年1月1日0时0分0秒到现在的毫秒数
     */
    @Test
    public void test1(){
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        // java 8
        System.out.println(Clock.systemDefaultZone().millis());
    }

    /**
     * 取得某月的最后一天
     */
    @Test
    public void test2(){
        Calendar time = Calendar.getInstance();
        int actualMaximum = time.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);
    }

    /**
     * 格式化日期
     */
    @Test
    public void test3(){
        // 利用java.text.DataFormat的子类(如SimpleDateFormat类)中的format(Date)方法可将日期格式化。
        // Java8 中可以用java.time.format.DataTimeFormatter来格式化时间日期
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));

        // Java8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));

        System.out.println(date2.getYear());
        System.out.println(date2.getDayOfYear());
        System.out.println(date2.getDayOfMonth());
        System.out.println(date2.getDayOfWeek());

        /**
         * 补充：Java8中引入了新的时间日期API, 其中包括LocalDate、LocalTime、LocalDateTime、Clock、Instant等类,
         * 这些类的设计都是用了不变模式, 因此都是线程安全的设计。
         * 参考： https://blog.csdn.net/jackfrued/article/details/44499227
         */
    }
}
