package LeetcodePrimaryAlgorithm.str;

/*
整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Demo02 {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            /*
            -2147483648——2147483647
            条件1：
            如果倒数第二位比最大值的倒数第二位正数大，负数小时，补上最后一位直接溢出
            条件2：
            条件一以满足，补齐最后一位时
            正数时，差一位溢出条件,最后一位要小于等于8
            负数时，差一位溢出条件,最后一位要大于等于-7
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
