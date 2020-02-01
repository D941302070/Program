package XueXiJiLu.Api.generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
        show01();
        show02();
    }

    /*
    创建集合对象，使用泛型
    好处：
        1.避免了类型转换的问题，存储什么类型，取出就是什么类型
        2.把运行期异常(代码执行后会抛出的异常)，提升到了编译期(写代码的时候会报错)
    弊端：
        泛型是什么类型，只能存储什么类型的数据
     */
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1);//报错

        //使用迭代器遍历list集合
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s.length());
        }
    }

    /*
    创建集合对象，不使用泛型
    好处：
        集合不使用泛型，默认类型为object类型，可以储存任意类型的数据
    弊端：
        不安全，会引发异常
     */
    private static void show01() {
        ArrayList list = new ArrayList();
        list.add("afe");
        list.add(1);

        //使用迭代器遍历list集合
        //获取迭代器
        Iterator it = list.iterator();
        //使用迭代器的方法hasNext和next遍历集合
        while (it.hasNext()) {
            //去除元素也是Object类型
            Object obj = it.next();
            System.out.println(obj);

            //想要使用String类特有的方法，length获取字符串长度；不能使用（多态）
            //需要向下转型
            //会抛出类型转换异常，不能将Integer类型转换为String
            String s = (String) obj;
            System.out.println(s.length());
        }
    }
}
