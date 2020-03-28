/**
 * 有bug
 */
/*
问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
输入格式
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开
样例输入
2 2
1 2
3 4
样例输出
7 10
15 22
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.util.Scanner;

public class text17 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//阶数
        int m = sc.nextInt();//幂数
        if (n == 1) {
            int tem = sc.nextInt();
            System.out.println((int) Math.pow(tem, m));
            return;
        }
        long[][] basic = new long[n][n];
        long[][] temp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = sc.nextLong();
                basic[i][j] = temp[i][j];
            }
        }
        if(m == 0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = 0;
                    if (i==j)
                        temp[i][j] = 1;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(temp[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < m - 1; i++) {
            temp = mul(temp,basic);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] mul(long temp[][],long basic[][]) {
        long[][] c = new long[temp.length][temp.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp.length; k++) {
                    c[i][j] += temp[i][k] * basic[k][j];
                }
            }
        }
        return c;
    }
}

