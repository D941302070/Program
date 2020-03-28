package LanQiaoYuSai.yusai;

import java.util.Scanner;

public class text5 {

    public static void main(String[] args) {
        char[] ch = new char[100];
        String in;
        in = new Scanner(System.in).nextLine();
        ch = in.toCharArray();
        int i = 0;
        for (; i < ch.length; i++) {
            if (ch[i] == 'a' | ch[i] == 'e' | ch[i] == 'i' | ch[i] == 'o' | ch[i] == 'u') {
                System.out.println(ch[i]);
                break;
            }
        }
        if ((ch[ch.length - 1] != 'a' | ch[ch.length - 1] != 'e' | ch[ch.length - 1] != 'i' | ch[ch.length - 1] != 'o' | ch[ch.length - 1] != 'u') & i == ch.length) {
            System.out.println('n');
        }
    }

}
