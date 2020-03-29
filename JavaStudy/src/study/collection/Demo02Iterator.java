package study.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
java.util.Iterator接口：迭代器(对集合进行遍历)
有两个常用方法：
    boolean hasNext()如果迭代具有更多元素，则返回 true 。
        判断集合还有没有下一个元素，如果有返回true，如果没有返回false
    E next()返回迭代中的下一个元素。
        取出集合中的下一个元素

    Iterator迭代器是一个接口，无法直接使用，需要实现类对象，获取实现类方法比较特殊
    Collection接口中有一个方法iterator()，返回的就是Iterator实现类对象
        Iterator<E> iterator() 返回此集合中的元素的迭代器。

    迭代器的使用步骤（重点）：
        1.先使用集合中的方法iterator()获取迭代器实现类对象，用Iterator接口接受（多态）
        2.用Iterator接口中的方法hasNext()方法判断还有没有下一个元素
        3.用Iterator接口中的方法next()方法切除集合中的下一个元素
 */
public class Demo02Iterator {
    public static void main(String[] args) {
        //创建对象
        Collection<String> coll = new ArrayList<>();
        //添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");
        /*
        1.先使用集合中的方法iterator()获取迭代器实现类对象，用Iterator接口接受（多态）
        注意事项：
           Iterator<E>接口也是有泛型的，迭代器泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
         */
        Iterator<String> it = coll.iterator();
        //2.用Iterator接口中的方法hasNext()方法判断还有没有下一个元素
        boolean b = it.hasNext();
        System.out.println(b);
        //3.用Iterator接口中的方法next()方法切除集合中的下一个元素
        String s = it.next();
        System.out.println(s);

        //优化
        while(it.hasNext()){
            String s1 = it.next();
            System.out.println(s1);
        }
    }
}
