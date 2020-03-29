package study.other;

/**
 * Math类的部分用法
 * 
 * @author 淺い空
 */
public class Math_api {
    public static void main(String[] args) {
        System.out.println("10/3取整=" + Math.floor(10.0 / 3));// 取整

        System.out.println("3.75取整第一位四舍五入=" + Math.round(3.75));// 对小数点后第一位四舍五入

        System.out.println("-10绝对值" + Math.abs(-10));// 取绝对值

        System.out.println("3的4次方=" + Math.pow(3, 4));// 3的4次方

        System.out.println("120的平方根" + Math.sqrt(120));// 平方根

        System.out.println(Math.round(3.75 * 10) / 10.0);// 保留小数点后一位四舍五入
    }

}