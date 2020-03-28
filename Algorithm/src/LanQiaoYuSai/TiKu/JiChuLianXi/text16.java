/*
问题描述
　　求出区间[a,b]中所有整数的质因数分解。
输入格式
　　输入两个整数a，b。
输出格式
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
样例输入
3 10
样例输出
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5
提示
　　先筛出所有素数，然后再分解。
数据规模和约定
　　2<=a<=b<=10000
 */
/**
 * bug
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.util.Scanner;

public class text16 {

    public static void method() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            int temp = i;
            System.out.print(temp + "=");
            boolean flag = false;
            while (temp != 1) {
                //每次从小到大找，找到一个就求除数，然后重新开始找
                for (int j = 2; j <= temp; j++) {
                    if (isPrimer(j) && temp % j == 0) {
                        temp /= j;
                        if (flag) {
                            System.out.print("*");
                        }
                        System.out.print(j);
                        flag = true;
                        //break;
                    }

                }

            }
            System.out.println();
        }
    }

    public static boolean isPrimer(int N) {
        if (N < 2)
            return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        method();
    }

}
