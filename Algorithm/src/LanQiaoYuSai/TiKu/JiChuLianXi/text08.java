/*
问题描述
　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的四位十进制数。
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;


public class text08 {

    public static void main(String[] args) {

        for (int i = 1000; i < 10000; i++) {
            int diandao = 0;
            int temp = i;
            while (temp != 0) {//将整数倒序排列
                if (i % 10 == 0) {
                    break;
                }
                int pop = temp % 10;
                temp /= 10;
                diandao = diandao * 10 + pop;
            }
            if (diandao == i) {
                System.out.println(i);
            }
        }

    }
}
