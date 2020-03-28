package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
public class Demo22 {
    static List<String> list = new ArrayList<>();
    static int total;

    public static List<String> generateParenthesis(int n) {

        if (n == 0) return list;
        if (n == 1) {
            list.add("()");
            return list;
        }
        total = n;
        newMethod(0, 0, "");
        return list;
    }

    public static void newMethod(int left, int right, String str) {
        if (left + right == 2 * total) {
            list.add(str);
            return;
        }
        //1.当前括号不结束进入下一层，
        if (left < total)
            newMethod(left + 1, right, str + "(");
        //2.结束当前括号，并在下次开新括号
        if (left > right)
            newMethod(left, right + 1, str + "(");
    }
    /*
    totalNum:进行的总括号数计数
    nowNum：当前未完成括号数计数
    str：上一层字符串
     */
    /*public static void createString(int totalCount, int nowCount, String str) {

        if (totalCount == total + 1) {
            if (nowCount == 1) list.add(str);
            else if (nowCount != 2||totalCount ==nowCount) {
                for (int i = 0; i < nowCount - 1; i++) str += ")";
                list.add(str);
            }
            return;
        }
        if (totalCount == total - 1) {
            for (int i = 0; i < nowCount + 1; i++) str += ")";
            list.add(str);
            return;
        }
        //1.当前括号不结束进入下一层，
        createString(totalCount + 1, nowCount + 1, str);
        //2.结束当前括号，并在下次开新括号
        createString(totalCount + 1, 1, str);
    }*/
}

