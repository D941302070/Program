package XueXiJiLu.Api.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
java.util.Collection
    所有单列集合最顶层的接口，里边定义了所有单列集合共性的方法
    任意的单列机和都可以使用Collection接口中的方法


共性的方法：
    public boolean add(E e)：  把给定的对象添加到当前集合中 。
    public void clear() :清空集合中所有的元素。
    public boolean remove(E e): 把给定的对象在当前集合中删除。
    public boolean contains(E e): 判断当前集合中是否包含给定的对象。
    public boolean isEmpty(): 判断当前集合是否为空。
    public int size(): 返回集合中元素的个数。
    public Object[] toArray(): 把集合中的元素，存储到数组中。
 */
public class Demo01 {
    public static void main(String[] args) {
        //创建集合对象，可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//重写了toString方法

        /*
        public boolean add(E e)：  把给定的对象添加到当前集合中 。
        返回值是一个boolean值，一般都返回true，所以可以不用接受
         */
        boolean b1 = coll.add("张三");
        System.out.println(coll);
        System.out.println(b1);
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        /*
            public boolean remove(E e): 把给定的对象在当前集合中删除。
            返回值是Boolean值，集合中存在元素，删除元素,返回true
                              集合中不存在元素,删除失败,返回false
         */
        boolean b2 = coll.remove("赵六");
        System.out.println(b2);
        boolean b3 = coll.remove("赵四");
        System.out.println(b3);
        System.out.println(coll);

        /*
            public boolean contains(E e): 判断当前集合中是否包含给定的对象。
            包含返回true
            不包含返回false
         */
        boolean b4 = coll.contains("李四");
        System.out.println(b4);

        boolean b5 = coll.contains("赵四");
        System.out.println(b5);

        //public boolean isEmpty(): 判断当前集合是否为空。集合空返回true，不为空返回false
        boolean b6 = coll.isEmpty();
        System.out.println(b6);
        //public int size(): 返回集合中元素的个数。
        int size = coll.size();
        System.out.println(size);

        // public Object[] toArray(): 把集合中的元素，存储到数组中。
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //public void clear() :清空集合中所有的元素。
        coll.clear();
        System.out.println(coll);
    }
}
