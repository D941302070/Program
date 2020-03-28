package XueXiJiLu.Api.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
java.util.List 接口extends Collection接口
List接口的特点：
    1.有序的集合，储存元素和取出元素的顺序是一致的（储存123，取出123）
    2.有索引，包含了一些带索引的方法
    3.允许存储重复元素

List接口中带索引的方法（特有）
    public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
    public E get(int index):返回集合中指定位置的元素。
    public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
    public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。

注意：
    操作所索引的时候，一定要防止索引越界
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个集合对象
        List<String> list = new ArrayList<>();
        //使用add方法给集合添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        System.out.println(list);

        //public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
        //在c和d之间添加一个元素
        list.add(3, "dwdw");
        System.out.println(list);

        //public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
        //移除元素
        String removed = list.remove(2);
        System.out.println("被移除的元素是" + removed);
        System.out.println(list);

        //public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
        //把最后一个a替换为A
        String set = list.set(4, "A");
        System.out.println("被替换的元素" + set);
        System.out.println(list);

        //List集合遍历有3种方式
        //使用普通的for循环
        for (int i = 0; i < list.size(); i++) {
            //public E get(int index):返回集合中指定位置的元素。
            String s = list.get(i);
            System.out.println(s);
        }

        //使用迭代器遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

        //使用增强for循环
        for (String s : list) {
            System.out.println(s);
        }
    }
}
