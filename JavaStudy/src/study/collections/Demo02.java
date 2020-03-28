package XueXiJiLu.Api.collections;

import java.util.ArrayList;
import java.util.Collections;

/*
`public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序

注意事项：
    sort(List<T> list)适用前提
    被排序的集合里边储存的元素，必须实现Comparable，重写接口里的方法comparableTo定义排序规则

Comparable接口的排序规则：
    自己(this)-参数：升序
    参数-自己(this)：降序
 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();//ArrayList有序
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);

        Collections.sort(list01);//默认升序
        System.out.println(list01);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("c");
        list02.add("b");
        System.out.println(list02);
        Collections.sort(list02);

        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("张三",18));
        list03.add(new Person("李四",20));
        list03.add(new Person("王五",15));
        System.out.println(list03);

        Collections.sort(list03);
        System.out.println(list03);
    }
}
