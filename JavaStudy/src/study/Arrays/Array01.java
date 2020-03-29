package study.Arrays;

import java.util.Arrays;

/**
 * public static String toString(数组);将参数变为字符串（按照默认格式[元素1，元素2,……]）
 * public static void sort(数组);//按照默认升序对元素进行排序
 *
 * 注：
 * 1.如果是数字，sort自动按升序排列
 * 2.如果是字符串，sort默认按字母升序
 * 3.如果是自定义的类，那么这个自定义的类需要有Comparable或Comparator接口的支持
 */
public class Array01 {

    public static void main(String[] args) {
        int[] intArray = {10, 20, 30};
        String intStr= Arrays.toString(intArray);
        System.out.println(intStr);
        System.out.println("===================");

        int[] array1={2,1,3,10,6};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));//不需要遍历，快速查看
        System.out.println("===============");

        String[] array2 = {"bbb","aaa","ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));

    }

}
