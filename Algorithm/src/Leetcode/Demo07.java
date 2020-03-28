package Leetcode;

/**
 * 
 * @author 八级大哥段
 *
 * @question 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 
 *           示例 1:
 * 			  输入: 123 输出: 321   
 * 			  示例 2: 
 *           输入: -123 输出: -321
 *           示例 3: 
 *           输入: 120 输出: 21 
 *           
 *           注意:
 *           假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 −
 *           1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * 
 */

public class Demo07 {

	public static int reverse(int x) {

		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		String str = String.valueOf(Math.abs(x));// 将整数转化为字符串
		char[] chars = str.toCharArray();// 将字符串转换为字符数组
		for (int i = 0; i < chars.length / 2; i++) {// 交换位置
			char temp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = temp;
		}
		String str2 = String.valueOf(chars);// 字符数组转化为字符串
		if (Long.parseLong(str2) > (Math.pow(2, 31)) - 1 || Long.parseLong(str2) < Math.pow(2, 31) * (-1)) {
			return 0;
		} else {
			if (x < 0) {
				return Integer.parseInt(str2) * (-1);// 将字符串转化为整形或Integer.valueOf(s).intValue()
			} else {
				return Integer.parseInt(str2);
			}
		}
	}

	public static int reverse2(int x) {// 标准答案
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static void main(String[] args) {
		int x = 214748364;
		long startTime1 = System.nanoTime(); // 获取开始时间;System.currentTimeMillis()以毫秒为单位
		System.out.println(reverse(x));
		long endTime1 = System.nanoTime(); // 获取结束时间
		long startTime2 = System.nanoTime(); // 获取开始时间
		System.out.println(reverse2(x));
		long endTime2 = System.nanoTime(); // 获取结束时间
		System.out.println("自己写的程序：" + (endTime1 - startTime1) + "纳秒");
		System.out.println("参考答案：" + (endTime2 - startTime2) + "纳秒");
	}

}
