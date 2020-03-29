package study.StringBuilder;
/*
StringBuilder的常用方法
    public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
 */
public class Demo02 {
    public static void main(String[] args) {
        //创建StringBuilder对象
        StringBuilder bu = new StringBuilder();
        //使用append方法往StringBuilder中添加数据
        //append方法返回的是this，调用方法的对象bu，this==bu
        StringBuilder bu2 = bu.append("abc");//把bu地址赋值给了bu2
        System.out.println(bu);
        System.out.println(bu2);
        System.out.println(bu==bu2);//地址一样返回true

        //使用append方法无需接收返回值
        bu.append("abcd");
        bu.append(1);
        bu.append(true);
        bu.append(8.8);
        bu.append('中');
        System.out.println(bu);

        /*
        链式编程：方法返回值是一个对象，可以继续调用方法
         */

        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase().toLowerCase());

        bu.append('我').append("love").append(18).append("岁的王豆豆");
        System.out.println(bu);
    }
}
