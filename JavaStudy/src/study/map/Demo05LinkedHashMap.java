package XueXiJiLu.Api.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
java.util.LinkedHashMap<K,V> extends HashMap<K,V>
哈希表和链表实现的Map接口，具有可预测的迭代次序
底层原理：
    哈希表+链表(记录元素的顺序)
 */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        map.put("d","d");
        System.out.println(map);//key不许重复，无序

        LinkedHashMap<String, String> linked = new LinkedHashMap<>();
        linked.put("a","a");
        linked.put("c","c");
        linked.put("b","b");
        linked.put("d","d");
        System.out.println(linked);//key不许重复，有序
    }
}
