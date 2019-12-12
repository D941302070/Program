package XueXiJiLu.Api.String_api;

/**
 * 分割字符串的方法
 * ================
 * public String[] spilt(String regex);按照参数规则将字符串分为若干部分
 *
 * 注：spilt的参数是一个正则表达式
 * 若使用"."划分，必须写"\\."
 */
public class String06Split {

    public static void main(String[] args) {

        String str1 = "aaa,bbb,ccc";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("=================");


    }

}
