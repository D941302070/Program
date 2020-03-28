package LanQiaoYuSai.yusai;

import java.util.Scanner;

public class text6 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int flag = 0;

        for (int i = 1; i <= n; i++) {
            int rev = i;
            while (true) {
                if (rev==0){
                    break;
                }
                int yu = rev % 10;
                if (yu == 2) {
                    flag++;
                    break;
                }
                rev = (rev - yu) / 10;
            }
        }
        System.out.println(n-flag);

    }

}
