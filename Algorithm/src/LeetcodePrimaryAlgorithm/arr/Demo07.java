package LeetcodePrimaryAlgorithm.arr;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class Demo07 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        boolean flag = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag) digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
                flag = true;
            }else return digits;
        }
        //既然最高位要进位，所以之后的数字绝对是0，数组初始化全为0，只需要改第一位的1
        if (flag) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
