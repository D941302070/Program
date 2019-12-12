/*
问题描述
　　最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
　　不妨设
　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。
输入格式
　　仅有一个数：N<201。
输出格式
　　请输出相应的表达式Sn，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入
3
样例输出
((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.util.Scanner;

public class text21 {

    public static void Sn(int n){

        for (int i = 0; i < n-1; i++) {
            System.out.print("(");
        }
        for (int i = 1; i < n+1; i++) {
            An(i);
            System.out.print("+"+(i-1));
            if (i==n){
                return;
            }else {
                System.out.print(")");
            }
        }

    }

    public static void An(int n){
        System.out.print("A"+n);
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        Sn(n);
    }

}
