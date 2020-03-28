package XueXiJiLu.Api.String_api;

/**
 * @author 八级大哥段
 */
public class String04Get {

    public static void main(String[] args) {

        //获取字符串长度
        int length = "ddwdwdwdffrfrsfgr".length();
        System.out.println("字符串长度为"+length);
        System.out.println("================");

        //拼接字符串
        String str1 = "hello";
        String str2 = "world";
        String str3 = str1.concat(str2);
        System.out.println(str3);
        System.out.println("================");

        //获取指定未知的单个字符
        char str4 = "hello".charAt(1);
        System.out.println(str4);
        System.out.println("================");

        //查找参数字符串在字符串中第一次出现的位置
        //如果没有，返回值为-1
        int place = str1.indexOf("llo");
        System.out.println(place);

    }

}
