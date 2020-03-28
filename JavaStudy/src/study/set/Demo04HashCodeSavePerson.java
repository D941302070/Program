package XueXiJiLu.Api.set;

import java.util.HashSet;

/*
HashSet存储自定义类型元素

Set集合报错元素唯一：
    储存的元素（String，Integer……Student，Person……），必须重写hashCode和equals方法

要求:
同名同年龄的人，视为同一个人，只能储存一次
 */
public class Demo04HashCodeSavePerson {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("小明",18);
        Person p2 = new Person("小明",18);
        Person p3 = new Person("小明",19);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }
}
