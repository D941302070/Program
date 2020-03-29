package study.other;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 八级大哥段
 * Random用来生成随机数字
 */

public class Random_api {

    public static void main(String[] args) {

        Random r = new Random();
        int ra = r.nextInt();//nextInt括号无参，随机一个整数，有参，从0到参数随即一个整数
        int ra2 = r.nextInt(5);//有参，从[0,5)到参数随即一个整数,即0~4
        int ra3 = r.nextInt(5) + 1;//实际范围是[1,6),即[1,5]
        game();
    }

    public static void game() {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;
        while (true) {
            System.out.println("请输入猜测的数字");
            int guessNum = new Scanner(System.in).nextInt();
            if (guessNum > randomNum) {
                System.out.println("太大了，请重新输入");
            } else if (guessNum < randomNum) {
                System.out.println("太小了，请重新输入");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
        System.out.println("游戏结束");
    }
}
