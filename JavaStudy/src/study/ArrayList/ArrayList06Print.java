package XueXiJiLu.Api.ArrayList_api;

import java.util.ArrayList;

/**
 * 指定格式打印集合，要求{}，用@分割元素
 */
public class ArrayList06Print {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("段星雨");
        list.add("李华");
        list.add("小明");
        printArrayList(list);
    }

    private static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i) + "}");
            } else {
                System.out.print(list.get(i) + "@");
            }

        }
    }
}
