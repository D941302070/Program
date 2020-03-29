package study.ArrayList;

import java.util.ArrayList;

/**
 * 如果希望在ArrayList集合里存放基本类型数据，必须使用基本类型对应的包装类
 *
 * 基本类型   包装类(引用类型：在java.lang不需要导包)
 * byte       Byte
 * short      Short
 * int        Integer
 * lang       Lang
 * floor      Floor
 * double     Double
 * char       Character
 * boolean    Boolean
 */
public class ArrayList03Basic {
    public static void main(String[] args) {

        ArrayList<String> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        listB.add(100);

    }
}
