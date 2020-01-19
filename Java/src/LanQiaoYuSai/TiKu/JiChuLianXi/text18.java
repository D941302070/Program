/*
问题描述
　　平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。
输入格式
　　输入仅包含两行，每行描述一个矩形。
　　在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
输出格式
　　输出仅包含一个实数，为交的面积，保留到小数后两位。
样例输入
1 1 3 3
2 2 4 4
样例输出
1.00
 */
package LanQiaoYuSai.TiKu.JiChuLianXi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class text18 {

    public static void method() {
        double[] temp = new double[8];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            temp[i] = sc.nextDouble();
        }
        double[][] a = new double[4][2];
        double[][] b = new double[4][2];
        /*
        矩形四行对应左上0，右上1，左下2，右下3
        第二位0位x，1位y
         */
        int _X_ = 0;
        int _Y_ = 1;
        int left_up = 0, right_up = 1, left_down = 2, right_down = 3;
        a[left_down][_X_] = a[left_up][_X_] = Math.min(temp[0],temp[2]);
        a[left_down][_Y_] = a[right_down][_Y_] = Math.min(temp[1],temp[3]);
        a[right_up][_X_] = a[right_down][_X_] = Math.max(temp[0],temp[2]);
        a[right_up][_Y_] = a[left_up][_Y_] = Math.max(temp[1],temp[3]);
        b[left_down][_X_] = b[left_up][_X_] =Math.min(temp[4],temp[6]);
        b[left_down][_Y_] = b[right_down][_Y_] =Math.min(temp[5],temp[7]);
        b[right_up][_X_] = b[right_down][_X_] = Math.max(temp[4],temp[6]);
        b[right_up][_Y_] = b[left_up][_Y_] = Math.max(temp[5],temp[7]);
        double h, w;
        //上下相交(h)
        boolean h_a_up = a[left_up][_Y_] <= b[left_up][_Y_]
                && a[left_up][_Y_] > b[left_down][_Y_]; //a的较高y与b焦点
        boolean h_a_down = a[left_down][_Y_] < b[left_up][_Y_]
                && a[left_down][_Y_] >= b[left_down][_Y_]; //a的较低y与b焦点
        boolean h_b_up = b[left_up][_Y_] <= a[left_up][_Y_]
                && b[left_up][_Y_] > a[left_down][_Y_]; //a的较高y与b焦点
        boolean h_b_down = b[left_down][_Y_] < a[left_up][_Y_]
                && b[left_down][_Y_] >= a[left_down][_Y_]; //a的较低y与b焦点
        if (h_a_up && h_a_down)
            h = a[left_up][_Y_] - a[left_down][_Y_];
        else if (h_b_up && h_b_down)
            h = b[left_up][_Y_] - b[left_down][_Y_];
        else if (h_a_up)
            h = a[left_up][_Y_] - b[left_down][_Y_];
        else if (h_a_down)
            h = b[left_up][_Y_] - a[left_down][_Y_];
        else
            h = 0;
        //左右相交(w)
        boolean w_a_left = a[left_up][_X_] >= b[left_up][_X_]
                && a[left_up][_X_] < b[right_up][_X_]; //a的较左x与b焦点
        boolean w_a_right = a[right_down][_X_] > b[left_up][_X_]
                && a[right_down][_X_] <= b[right_down][_X_]; //a的较右x与b焦点
        boolean w_b_left = b[left_up][_X_] >= a[left_up][_X_]
                && b[left_up][_X_] < a[right_up][_X_]; //a的较左x与b焦点
        boolean w_b_right = b[right_down][_X_] > a[left_up][_X_]
                && b[right_down][_X_] <= a[right_down][_X_]; //a的较右x与b焦点
        if (w_a_left && w_a_right)
            w = a[right_down][_X_] - a[left_down][_X_];
        else if (w_b_left && w_b_right)
            w = b[right_down][_X_] - b[left_down][_X_];
        else if (w_a_left)
            w = b[right_down][_X_] - a[left_down][_X_];
        else if (w_a_right)
            w = a[right_down][_X_] - b[left_down][_X_];
        else
            w = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(w * h));
    }

    public static void main(String[] args) {
        method();
    }

}
