package XueXiJiLu.Api.map.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
计算一个字符串中每个字符出现次数。
 */
public class Demo {
    public static void main(String[] args) {
        method();
    }

    private static void method() {
        String s = new Scanner(System.in).next();
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            /*
            判断Map里有没有当前字符
                1.get()
                存在返回value，不存在返回null
                2.containsKey()
                存在返回true，不存在返回false
             */
            if (map.get(charArray[i]) == null)
                map.put(charArray[i],1);
            else {
                //获取value，然后重新复制刷新
                Integer value = map.get(charArray[i]);
                map.put(charArray[i],++value);
            }
        }
        System.out.println(map);
    }
}
