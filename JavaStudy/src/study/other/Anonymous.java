package study.other;
/**
 * @author 八级大哥段
 *
 * 匿名对象
 */

import java.util.Scanner;

public class Anonymous {

    public static void method(Scanner sc) {
        String s = sc.nextLine();
    }

    public static Scanner method2() {
        return new Scanner(System.in);//匿名对象当返回值
    }

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        int tem1 = sc1.nextInt();//一般对象使用方式

        int tem2 = new Scanner(System.in).nextInt();//匿名对象方式

        int sum = new Scanner(System.in).nextInt();//只想使用一次的对象可用匿名对象

        Scanner sc2 = new Scanner(System.in);
        method(sc2);//一般传参方法

        method(new Scanner(System.in));//匿名对象传参
    }
}
