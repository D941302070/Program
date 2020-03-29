package study.collections;

import java.util.ArrayList;
import java.util.Collections;

/*

`java.utils.Collections`是集合工具类，用来对集合进行操作。部分方法如下：

- `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。
- `public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        /*list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");*/

        //- `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。
        Collections.addAll(list,"a","b","c","d");
        System.out.println(list);

        //- `public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。
        Collections.shuffle(list);
        System.out.println(list);
    }
}
