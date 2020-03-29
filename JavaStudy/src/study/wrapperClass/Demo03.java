package study.wrapperClass;

/*
基本类型和字符串类型之间的相互转换
基本类型->字符串（String）
    1.基本类型+""最简单的方法(工作中常用)
    2.包装类的静态方法toString（参数）不是Object类的toString重载
        static String toString(int i) 返回一个 String指定整数的 String对象。
    3.String类的静态方法valueOf()
        static String valueOf(int i) 返回 int参数的字符串 int形式。
字符串->基本类型
    使用包装类的静态方法parseXXX("字符串")；
        Integer类：static int parseInt(String s)
        Byte类：static byte parseByte(String s)
        Short类：static short parseShort(String s)
        Long类：static long parseLong(String s)
        Float类：static float parseFloat(String s)
        Double类：static double parseDouble(String s)
        Boolean类：static boolean parseBoolean(String s)
 */
public class Demo03 {

    public static void main(String[] args) {
        //基本类型->字符串（String）
        int i1 = 1080;
        String s1 = i1 + "";
        System.out.println(s1+989);

        String s2 = Integer.toString(i1);
        System.out.println(s2+2903);

        String s3 = String.valueOf(3784);
        System.out.println(s3+3039);

        //字符串->基本类型
        int i2 = Integer.parseInt(s1);
        System.out.println(i2-10);
    }

}
