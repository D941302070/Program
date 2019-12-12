/*
问题描述
给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。

输入格式
第一行包含一个数n，表示序列长度。

第二行包含n个正整数，表示给定的序列。

第三个包含一个正整数m，表示询问个数。

接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。

输出格式
总共输出m行，每行一个数，表示询问的答案。
样例输入
5
1 2 3 4 5
2
1 5 2
2 3 2
样例输出
4
2
数据规模与约定
对于30%的数据，n,m<=100；

对于100%的数据，n,m<=1000；

保证k<=(r-l+1)，序列中的数<=106。
 */
package LanQiaoYuSai.TiKu.suanfaxunlian;

import java.util.Scanner;

public class text01 {


    public static void method() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] l = new int[m];
        int[] r = new int[m];
        int[] K = new int[m];
        for (int i = 0; i < m; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
            K[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            out(array, l[i], r[i], K[i]);
        }
    }

    public static void out(int[] array, int l, int r, int K) {

        int len = r - l + 1;
        int[] newArray = new int[len];
        for (int i = l; i < r+1; i++) {
            newArray[i-l] = array[i-1];
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (newArray[j] > newArray[j + 1]) {
                    int temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
        }
        System.out.println(newArray[len-K]);
    }

    public static void main(String[] args) {
        method();
    }
}
