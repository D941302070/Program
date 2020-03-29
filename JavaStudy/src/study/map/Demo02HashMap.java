package study.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的第一种遍历方式：通过键找值得方式
Map集合中的方法：
    Set<K> keySet() 返回此地图中包含的键的Set视图。
实现步骤：
      1.使用Map集合中的方法keySet()，把Msp集合所有的key取出来，储存到一个Set集合中
      2.遍历set集合，获取Map集合中的每一个Key
      3.通过Map集合中的方法get(key)，通过key找到value
 */
public class Demo02HashMap {
    public static void main(String[] args) {
        //创建Map集合对象，多态
        Map<String, Integer> map = new HashMap<>();
        map.put("赵丽颖", 168);
        map.put("杨颖", 165);
        map.put("林志玲", 178);

        //1.使用Map集合中的方法keySet()，把Msp集合所有的key取出来，储存到一个Set集合中
        Set<String> set = map.keySet();
        //2.遍历set集合，获取Map集合中的每一个Key
        //使用迭代器遍历
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            //3.通过Map集合中的方法get(key)，通过key找到value
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
        System.out.println("---------------");
        //使用增强for遍历
        for (String i : set) {
            //3.通过Map集合中的方法get(key)，通过key找到value
            Integer value = map.get(i);
            System.out.println(i + "=" + value);
        }

    }
}
