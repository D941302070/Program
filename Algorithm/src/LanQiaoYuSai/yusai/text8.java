package LanQiaoYuSai.yusai;

import java.util.Scanner;

public class text8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] num = new int[n][m];
        int direction = 1;//1右2下3左4上
        int result = 1;
        while (result != n * m + 1) {
            if (direction % 4 == 1) {//向右
                if (result == m * n + 1) break;
                int left = 0;
                int right = 0;
                while (num[left][right] != 0) {
                    left++;
                    right++;
                }

                while (num[left][right] == 0) {
                    num[left][right] = result;
                    right++;
                    result++;
                    if (right == n + 1) break;
                }

            }

            if (direction % 4 == 2) {//向下
                if (result == m * n + 1) break;
                int left = 0;
                int right = m - 1;
                while (!(num[left][right] != 0 & num[left + 1][right] == 0)) {
                    left++;
                    right--;
                }
                left++;


                while (num[left][right] == 0) {
                    num[left][right] = result;
                    left++;
                    result++;
                    if (left == m - 1) break;
                }
            }

            if (direction % 4 == 3) {//向左
                if (result == m * n + 1) break;
                int left = n - 1;
                int right = m - 1;
                while (!(num[left][right] != 0 & num[left][right - 1] == 0)) {
                    left--;
                    right--;
                }
                right--;


                while (num[left][right] == 0) {
                    num[left][right] = result;
                    right--;
                    result++;
                    if (right == -1) break;
                }
            }

            if (direction % 4 == 0) {//向上
                if (result == m * n + 1) break;
                int left = n - 1;
                int right = 0;
                while (!(num[left][right] != 0 & num[left - 1][right] == 0)) {
                    left--;
                    right++;
                }
                left--;


                while (num[left][right] == 0) {
                    num[left][right] = result;
                    left--;
                    result++;
                    if (left == -1) break;
                }
            }
            direction++;
        }


        System.out.println(num[r - 1][c - 1]);
    }

}
