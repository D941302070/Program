package XueXiJiLu.this_keyword;

/**
 * this关键字用法
 *  1.不能使用静态类和方法
 *   2.不能在this关键字前使用任何语句
 *
 * @author 淺い空
 */
public class thisKeyword {
	int count = 1;

	// this可在方法里调用外部与参数同名变量
	public void methonOne(int count) {
		System.out.println(count);
		System.out.println(this.count);
	}

	public thisKeyword(int a) {
		if (a == 1) {
			System.out.println("无参");
		} else {
			System.out.println("有参");
		}
	}

	public thisKeyword() {
		this(1);
	}
}