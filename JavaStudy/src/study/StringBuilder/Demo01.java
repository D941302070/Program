package study.StringBuilder;
/*
java.lang.StringBuilder类：字符串缓冲区，可以提高字符串效率
构造方法：
    public StringBuilder()：构造一个空的StringBuilder容器。
    public StringBuilder(String str)：构造一个StringBuilder容器，并将字符串添加进去。

 */
public class Demo01 {

    public static void main(String[] args) {
        //空参构造方法
        StringBuilder bu1 = new StringBuilder();
        System.out.println(bu1);//默认空串

        StringBuilder bu2 = new StringBuilder("abc");
        System.out.println(bu2);
    }

}
