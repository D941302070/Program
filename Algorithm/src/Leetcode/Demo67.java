package Leetcode;

/*
67. 二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 */
public class Demo67 {
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int i = a.length() - 1; i > -1; i--) {
            if (a.charAt(i) == '1') flag++;
            int j = i - (a.length() - b.length());
            if (j >= 0 && b.charAt(j) == '1') flag++;
            sb.append(flag % 2);
            flag /= 2;
        }
        if (flag==1) sb.append(1);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        addBinary("1010", "1011");
    }
}
