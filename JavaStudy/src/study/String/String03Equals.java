package study.String;
/**
 * equals比较内容
 * equalsIgnoreCase忽略大小写比较内容
 */
public class String03Equals {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str3.equals("abc"));//true（不推荐），str3=null时出现空指针异常
        System.out.println("abc".equals(str1));//true(推荐)
        //
        String str4 = "ABC";
        System.out.println(str4.equalsIgnoreCase(str1));//true
    }

}
