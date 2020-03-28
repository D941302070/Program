package XueXiJiLu.Api.Date;

import java.util.Date;

public class demo02_date {

    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }
    /*
    Date类的空参数构造方法
    Date() 获取当前系统的日期和时间
    */
    private static void demo01(){
        Date date = new Date();
        System.out.println(date);
    }

    /*
    Date类的带参数构造方法
    Date（long date）：传递毫秒值，把毫秒值转换为date日期
     */
    private static void demo02(){
        Date date = new Date(0L);
        System.out.println(date);

        date = new Date(15362838263876L);
        System.out.println(date);
    }

    /*
    long getTime() 把日期转换为毫秒值
     */
    private static void demo03(){
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }
}
