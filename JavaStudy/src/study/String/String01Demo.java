package XueXiJiLu.Api.String_api;


/**
 * 注：1.字符串只要被创建就不可被改变
 * 2.字符串可以共享使用
 * 3.所有双引号里的内容都是字符串
 * 4.字符串效果相当于char[]数组，但底层原理是byte[]字节数组
 */
public class String01Demo {

    public static void main(String[] args) {
        //空参构造
        String str1 = new String();
        System.out.println(str1);

        //根据字符数组创建字符串
        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println(str2);

        //根据字节数组创建字符串
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println(str3);

        //直接创建
        String str4 = "hello";
        System.out.println(str4);
    }
}
