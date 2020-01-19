/*
问题描述
　　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　交换的定义是：交换两个相邻的字符
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
输入格式
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
输出格式
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
样例输入
5
mamad
样例输出
3
https://blog.csdn.net/qq_41608020/article/details/80237792
https://blog.csdn.net/liuchuo/article/details/51990430
https://blog.csdn.net/qq_41608020/article/details/80237792
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.util.Scanner;

public class text19 {

    public static void method() {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//字符串长度
        String str = sc.next();
        int count = 0;//次数
        int len = N - 1;//每次寻找相同字符遍历次数
        char[] array = str.toCharArray();
        boolean flag = false;//若出现第一个不配对字符，变为true
        for (int i = 0; i < len; i++) {
            for (int j = len; j >= i; j--) {

                if (i == j) {  //单独的字符
                    if (N % 2 == 0 || flag) {//字符串偶数，或是已经出现过单数字符
                        System.out.println("Impossible");
                        return;
                    }
                    flag = true;
                    count += N / 2 - i;//第一次找到单独字符移动的次数
                    //暂时不移动单独字符，以为移动后每次移动都会再移动一次，最后移动单独字符即可
                }
                else if (array[i]==array[j]){//找到对应字符
                    for (int k = j; k < len; k++) {
                        char tem = array[k];
                        array[k] = array[k+1];
                        array[k+1] = tem;
                        count++;
                    }
                    len--;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        method();
    }

}
