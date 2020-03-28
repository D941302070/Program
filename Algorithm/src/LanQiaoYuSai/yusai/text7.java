package LanQiaoYuSai.yusai;

import java.util.Scanner;

public class text7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int flag = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a != 0 & i % b != 0 & i % c != 0)
                flag++;
        }
        System.out.println(flag);

    }

}
