package XueXiJiLu.ke_bian_can_shu;

/**
 * 关于可变参数的问题
 *
 * @author 淺い空
 *
 */
public class KeBianCanShu {
	// 求和
	public void sum(int... n) {// 参数n可以为数组
		// 可变参数列表所在的方法是最后被访问的
		int sum = 0;
		for (int i : n) {
			sum += i;
		}
		System.out.println("带可变参数方法先被调用");
		System.out.println("sum=" + sum);
	}

	public void sum(int a, int b) {
		int sum = 0;
		sum = a + b;
		System.out.println("不带可变参数方法先被调用");
		System.out.println("sum=" + sum);
	}

	public static void main(String[] args) {
		KeBianCanShu kbcs = new KeBianCanShu();
		kbcs.sum(1, 2);
	}
}