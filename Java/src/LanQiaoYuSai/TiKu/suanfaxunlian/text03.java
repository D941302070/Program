/*
问题描述
如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。
求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。
由于这个数目很大，请你输出它对1000000007取模后的值。

输入格式
输入包含两个正整数，K和L。

输出格式
输出一个整数，表示答案对1000000007取模后的值。
样例输入
4 2
样例输出
7
数据规模与约定
对于30%的数据，KL <= 106；

对于50%的数据，K <= 16， L <= 10；

对于100%的数据，1 <= K,L <= 100。
 */

package LanQiaoYuSai.TiKu.suanfaxunlian;
import java.util.Scanner;

public class text03 {

    public static void method() {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();//进制
        int l = sc.nextInt();//位数
        long[] array = new long [l];
        for (int i = 0; i < array.length; i++) {

        }
    }

    public static void main(String[] args) {
        method();
    }

}
