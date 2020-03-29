package Leetcode;

/**
 * 
 * @author 八级大哥段
 *
 * @question 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 *           示例 1: 
 *           输入: 121 输出: true 
 *           示例 2:
 *           输入: -121 输出: false 
 *           解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *           示例 3:
 *           输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。 
 *           
 *           进阶:
 *           你能不将整数转为字符串来解决这个问题吗？
 * 
 */
public class Demo09 {
	public static boolean isPalindrome(int x) {
		int rev = 0;
		int re = x;//储存刚进来的x
		if (x<0) {
			return false;//负的返回false
		}else {
			if (x%10 == 0&x/10!=0) {
				return false;//判断末尾是否为0
			}
			while (x != 0) {//将整数倒序排列
				int pop = x % 10;
				x /= 10;
				rev = rev * 10 + pop;
			}
			if (rev == re) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		int a = 121;
		isPalindrome(a);
	}
}