/*
问题描述
　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
　　输入一个正整数n， 编程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
输入格式
　　输入一行，包含一个正整数n。
输出格式
　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
样例输入
52
样例输出
899998
989989
998899
数据规模和约定
　　1<=n<=54。

*/
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.util.Scanner;

public class text09 {
    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
        for (int i = 10000; i < 1000000; i++) {
            int diandao = 0;
            int temp = i;
            int plus = 0;//个位数之和
            while (temp != 0) {//将整数倒序排列
                if(i%10==0)
                    break;
                int pop = temp % 10;
                temp /= 10;
                diandao = diandao * 10 + pop;
                plus = plus + pop;
            }
            if (diandao == i & plus == n) {
                System.out.println(i);
            }
        }
    }
}
