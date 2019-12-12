package XueXiJiLu.Api.String_api;

/**
 * 字符串直接写的在常量池中，new的对象不在池里
 * ==对于引用对象是比较地址值的
 *
 */
public class String02Pool {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);
        System.out.println(str1==str2);//true
        System.out.println(str1==str3);//false
        System.out.println(str2==str3);//false

    }

}
