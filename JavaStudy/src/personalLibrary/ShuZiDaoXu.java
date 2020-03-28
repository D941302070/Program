package PersonalLibrary;
/**
 * 
 *
 * @author 八级大哥段
 * @return 将整数倒序排列
 *
 */
public class ShuZiDaoXu {
	public static int change(int x) {
		int rev = 0;
		while (x != 0) {// 将整数倒序排列
			int pop = x % 10;
			x /= 10;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
