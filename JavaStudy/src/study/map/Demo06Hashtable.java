package study.map;

import java.util.HashMap;
import java.util.Hashtable;

/*
java.util.Hashtable<K,V>集合 implements Map<K,V>接口

Hashtable：底层也是一个哈希表，是一个线程安全集合，是单线程集合，速度慢
HashMap：底层是一个哈希表，是一个线程不安全集合，是多线程集合，速度快

HashMap集合(之前的所有集合)：可以储存null值，null键
Hashtable集合：不可以储存null值，null键

Hashtable和Vector集合一样，在JDK1.2版本之后被更先进的集合(HashMap,ArrayList)取代了
Hashtable的子类Properties依然活跃

Properties集合是唯一一个和IO流相结合的集合
 */
public class Demo06Hashtable {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("b",null);
        map.put(null,null);
        System.out.println(map);

        Hashtable<String, String> table = new Hashtable<>();
        table.put(null,"a");//报错，空指针异常
        table.put("b",null);//报错，空指针异常
        table.put(null,null);//报错，空指针异常
    }
}
