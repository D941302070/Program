package XueXiJiLu.Api.map;

import java.util.HashMap;
import java.util.Map;

/*
java.util.Map<K,V>集合
Map集合的特点：
    1.Map是一个双列集合，一个元素包含两个值(一个key，一个value)
    2.Map集合中的元素，key和value的数据类型可以相同可以不同
    3.Map集合中的元素，key不可以重复，value可以重复
    4.Map集合中的元素，key和value是一一对应的

java.util.HashMap<K,V>集合 implements Map<K,V>接口
HashMap集合的特点：
    1.HashMap集合底层是哈希表，查询的速度特别快
    2.HashMap是一个无序的集合，储存元素和取出元素可能不一致

java.util.LinkedHashMap<K,V>集合 extends HashMap<K,V>接口
LinkedHashMap集合的特点：
    1.LinkedHashMap底层是哈希表+链表（保证迭代顺序）
    2.LinkedHashMap是一个有序的集合，存储元素顺序和取出元素顺序是一致的
 */
public class Demo01HashMap {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
        show04();
    }

    /*
    boolean containsKey(Object key)  ` 判断集合中是否包含指定的键。
    包含返回true
    不包含返回false
     */
    private static void show04() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        boolean b1 = map.containsKey("赵丽颖");
        System.out.println(b1);//true

        boolean b2 = map.containsKey("赵颖");
        System.out.println(b2);//false
    }

    /*
    public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。
        返回值：V
            key存在，返回对应的value值
            key不存在，返回null
     */
    private static void show03() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        Integer v1 = map.get("杨颖");
        System.out.println(v1);//165

        Integer v2 = map.get("迪丽热巴");
        System.out.println(v2);//null
    }

    /*
    `public V remove(Object key)`: 把指定的键 所对应的键值对元素 在Map集合中删除
        返回值:V
            key存在，V返回被删除的值
            key不存在，V返回null
     */
    private static void show02() {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);
        System.out.println(map);

        Integer v1 = map.remove("林志玲");
        System.out.println(v1);//v1:178
        System.out.println(map);

        Integer v2 = map.remove("林志颖");
        //int v2 = map.remove("林志颖");//可能出现空指针异常
        System.out.println(v2);//v2:null
        System.out.println(map);
    }

    /*
    public V put(K key, V value)`:  把指定的键与指定的值添加到Map集合中。
    返回值：V
        存储键值对的时候，key不会重复，返回值V是null
        存储键值对的时候，key会重复，会使用新的value替换map中重复的value
     */
    private static void show01() {
        //创建Map集合对象，多态
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("李晨", "范冰冰1");
        System.out.println(v1);//v1:null
        String v2 = map.put("李晨", "范冰冰2");
        System.out.println(v2);//v2:范冰冰1

        System.out.println(map);

        map.put("冷锋", "龙小云");
        map.put("杨过", "小龙女");
        map.put("尹志平", "小龙女");

        System.out.println(map);

    }
}
