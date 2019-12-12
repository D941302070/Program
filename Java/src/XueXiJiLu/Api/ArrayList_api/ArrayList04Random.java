package XueXiJiLu.Api.ArrayList_api;

import java.util.ArrayList;
import java.util.Random;

/**
 * 生成6个1~33的随机数，并遍历循环
 *
 */
public class ArrayList04Random {
    public static void main(String[] args) {
        ArrayList<Integer> random=new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            random.add((new Random().nextInt(32))+1);
        }
        System.out.println(random);//直接输出
        for (int i = 0; i < random.size(); i++) {
            System.out.println(random.get(i));//遍历输出
        }
    }
}
