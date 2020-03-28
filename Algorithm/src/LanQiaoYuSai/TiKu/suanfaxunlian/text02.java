/*
问题描述
已知一个正整数N，问从1~N中任选出三个数，他们的最小公倍数最大可以为多少。

输入格式
输入一个正整数N。

输出格式
输出一个整数，表示你找到的最小公倍数。
样例输入
9
样例输出
504
数据规模与约定
1 <= N <= 106。
 */
package LanQiaoYuSai.TiKu.suanfaxunlian;

import java.util.Scanner;

public class text02 {
    /*
     如果求乘积最大值，从n开始找
     (1)、当N为奇数时,那么N,N-1,N-2互为质数,很明显N*N-1*N-2是1~N最小公倍数的最大值。
     (2)、当N为偶数时,且能被3整除时,N-1,N-2,N-3互质,此时N-1*N-2*N-3是1~N最小公倍数的最大值；
     当N为偶数时,但不能被3整除时,N,N-1,N-3互质,此时N*N-1*N-3是1~N最小公倍数的最大值。
     */

    public static void method() {
        long max;
        long n = new Scanner(System.in).nextLong();
        if (n <= 2) {//当n等于1或2的时候
            max = n;
        } else if (n % 2 == 1) {//当N为奇数时,N*N-1*N-2是1~N最小公倍数的最大值。
            max = n * (n - 1) * (n - 2);
        }
        else {//当n为偶数
            if (n % 3 == 0) {//能被3整除时,N-1,N-2,N-3互质,此时N-1*N-2*N-3是1~N最小公倍数的最大值；
                max = (n - 1) * (n - 2) * (n - 3);
            } else {//不能被3整除时,N,N-1,N-3互质,此时N*N-1*N-3是1~N最小公倍数的最大值。
                max = n * (n - 1) * (n - 3);
            }
        }
        System.out.println(max);

    }

    public static void main(String[] args) {
        method();
    }

}
