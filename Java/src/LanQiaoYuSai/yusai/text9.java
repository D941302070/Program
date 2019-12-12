package LanQiaoYuSai.yusai;

import java.util.Scanner;

public class text9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] cao = new char[n][m];
        char[][] flag = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                cao[i][j] = s.charAt(j);
            }
        }
        int k = sc.nextInt();
        while (k != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cao[i][j] == 'g') {
                        if (i != 0 ) {
                            flag[i - 1][j] = 'G';
                        }
                        if (j != 0 ) {
                            flag[i][j - 1] = 'G';
                        }
                        if (i != n - 1 ) {
                            flag[i + 1][j] = 'G';
                        }
                        if (j != m - 1 ) {
                            flag[i][j + 1] = 'G';
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (flag[i][j] == 'G') {
                        cao[i][j] = 'g';
                    }
                }
            }
            k--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cao[i][j]);
            }
            System.out.println();
        }
    }
}
