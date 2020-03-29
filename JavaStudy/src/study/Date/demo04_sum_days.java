package study.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
练习：使用时间有关的API，计算一个人出生了多少天

分析：
    1.使用Scanner类中的next方法，获取出生日期
    2.DateFormat类中的方法parse，把字符串的出生日期解析为Date格式的出生日期
    3.把Date格式的日期转换为毫秒值
    4.获取当前的日期，转换为毫秒值
    5.使用当前日期的毫秒值，减去出生日期的毫秒值
    6.把毫秒值转换为天
 */
public class demo04_sum_days {
    public static void main(String[] args) throws ParseException {
        method();
    }
    private static void method() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        Date startDate = sdf.parse("2018-11-01,00:00:00");
        Date nowDate = new Date();
        long passTime = nowDate.getTime()-startDate.getTime();
        System.out.println("============");
        System.out.println(passTime/1000/60/60/24+1);
        System.out.println("============");
    }

}
