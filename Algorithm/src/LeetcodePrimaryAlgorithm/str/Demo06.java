package LeetcodePrimaryAlgorithm.str;

/*
字符串转换整数 (atoi)
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

本题中的空白字符只包括空格字符 ' ' 。
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。


示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−2^31) 。
 */
public class Demo06 {
    public static int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int rev = 0, index, n = arr.length;
        int flag = 1;//1是正，-1为负
        for (index = 0; index < n; index++) {
            if (arr[index] == ' ') continue;
            //找到负号
            if (index <= n - 2 && arr[index] == '-' && Character.isDigit(arr[index + 1])) {
                flag = -1;
                index++;
                break;
            } else if (index <= n - 2 && arr[index] == '+' && Character.isDigit(arr[index + 1])) {
                index++;
                break;
            } else if (Character.isDigit(arr[index])) break;
            else return 0;
        }
        while (index < n && Character.isDigit(arr[index])) {
            int pop = arr[index] - '0';
            /*
            -2147483648——2147483647
            条件1：
            如果倒数第二位比最大值的倒数第二位正数大，负数小时，补上最后一位直接溢出
            条件2：
            条件一以满足，补齐最后一位时
            正数时，差一位溢出条件,最后一位要小于等于8
            负数时，差一位溢出条件,最后一位要大于等于-7
             */
            if (flag == 1 && (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)))
                return 2147483647;
            if (flag == -1 && (rev > -(Integer.MIN_VALUE / 10) || (rev == -(Integer.MIN_VALUE / 10) && pop > 8)))
                return -2147483648;
            rev = rev * 10 + pop;
            index++;
        }
        return rev * flag;
    }

    public static void main(String[] args) {
        myAtoi("21474836371");
    }
}
