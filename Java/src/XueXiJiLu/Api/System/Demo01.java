package XueXiJiLu.Api.System;

import java.util.Arrays;

/*
java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：

    public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
 */
public class Demo01 {

    public static void main(String[] args) {
        //demo01();
        demo02();
    }

    /*
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
    | 参数序号 | 参数名称    | 参数类型   | 参数含义       |
    | ---- | ------- | ------ | ---------- |
    | 1    | src     | Object | 源数组        |
    | 2    | srcPos  | int    | 源数组索引起始位置  |
    | 3    | dest    | Object | 目标数组       |
    | 4    | destPos | int    | 目标数组索引起始位置 |
    | 5    | length  | int    | 复制元素个数     |


    将src数组中前3个元素，复制到dest数组的前3个位置上复制元素前：src数组元素[1,2,3,4,5]，dest数组元素[6,7,8,9,10]复制元素后：src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
     */
    private static void demo02() {

        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};

        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
    }

    /*
     public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
     用来测试程序效率
     验证for循环打印数字1-9999所需要使用的时间（毫秒）
     */
    private static void demo01() {
        //程序执行前获取一次毫秒值
        long t1 = System.currentTimeMillis();
        for (int i = 0; i <= 9999; i++) {
            System.out.println(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("程序耗时：" + (t2 - t1) + "ms");
    }

}