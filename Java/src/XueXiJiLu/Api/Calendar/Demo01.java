package XueXiJiLu.Api.Calendar;

import java.util.Calendar;

/*
    java.util.Calender类：日历类
    Calendar类是一个抽象类，里面提供了许多操作日历字段的方法(YEAR、MONTH、DAY_MONTH、HOUR)
    Calender类无法直接创建对象使用，里面有一个静态方法getInstance()，该方法返回了Calendar类的子类对象
    static Calender getInstance()使用默认时区和语言环境获得一个日历
 */
public class Demo01 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();//父类接收子类对象，多态
        System.out.println(c);
    }

}
