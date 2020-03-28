package study.ArrayList;

import java.util.ArrayList;

/**
 * ArrayList长度可以发生变化
 *
 * 对于ArrayList有一个<E>代表泛型
 *
 * 泛型：装在集合中的所有元素都为同一类型
 *
 * 注：1.泛型只能为引用类型，不能为基本类型
 *     2.对于ArrayList，直接答应得到的不是地址值，而是内容
 *       如果为空，则打印的事[]
 */
public class ArrayList01Demo {
    public static void main(String[] args) {
        //常见了一个ArrayList集合，装在的都是String类型的数据
        //从JDK1.7+开始，右侧的括号可以不写东西
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);//对于ArrayList，直接答应得到的不是地址值，而是内容如果为空，则打印的事[]

        //向集合中添加数据，使用add方法
        list.add("段星雨");
        list.add("李华");
        list.add("小明");
        System.out.println(list);
    }
}

