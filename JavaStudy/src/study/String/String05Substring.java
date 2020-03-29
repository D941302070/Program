package study.String;

/**
 * 字符串截取方法
 * =======================
 * public String substring(int index);从参数一直到索引结束
 * ======================
 * public String substring(int begin ，int end);从begin开始，到end结束
 * [begin,end)
 */
public class String05Substring {

    public static void main(String[] args) {

        String str1 = "helloworld";
        String str2 = str1.substring(5);
        System.out.println(str2);
        System.out.println("=============");

        String str3 = str1.substring(5,7);
        System.out.println(str3);
    }

}
