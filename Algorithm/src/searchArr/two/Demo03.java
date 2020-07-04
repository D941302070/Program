package searchArr.two;

import java.util.ArrayList;
import java.util.List;

/*
对角线遍历
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。



示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:

 */
public class Demo03 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length < 1) return new int[0];
        int i = 0, j = 0;
        int row = matrix.length, low = matrix[0].length;
        //true是向右上，false是向左下
        int[] res = new int[low * row];
        int index = 0;
        boolean dir = true;
        while (i != row - 1 || j != low - 1) {
            res[index++] = matrix[i][j];
            if (dir) {
                if (j == low - 1) {
                    i++;
                    dir = false;
                } else if (i == 0) {
                    j++;
                    dir = false;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == row - 1) {
                    j++;
                    dir = true;
                } else if (j == 0) {
                    i++;
                    dir = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        res[index] = matrix[row - 1][low - 1];
        return res;
    }
}
