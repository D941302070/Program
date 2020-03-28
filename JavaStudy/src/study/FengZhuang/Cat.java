package XueXiJiLu.FengZhuang;

/**
 * 宠物猫类
 * 
 * @author 淺い空 构造方法： 1.与类名相同 2.无返回值 3.只能在方法实例化的时候使用，即使用new关键字的时候
 *         4.若无构造方法时，系统自动构造一个无参构造方法
 *
 */
public class Cat {
	// 成员属性：昵称、年龄、体重、品种
	private String name;// 昵称 String类型默认值null
	private int month;// 年龄 int类型默认值0
	private double weight;// 体重 double类型默认值0.0
	private String species;// 品种

	// static:静态 静态成员
	// 1.类对象共享
	// 2.类加载时产生，销毁时释放
	public static int price;// 售价

	// 静态方法
	// 1.不可在内调用当前类中的非静态方法，不能使用当前类中的静态属性
	// 2.只能通过对象实例化后调用
	public static void eat() {
		System.out.println("小猫吃鱼");
		Cat temp = new Cat();
		temp.run();
		temp.name = "李华";
	}

	{
		System.out.println("构造代码块");
	}// 构造代码块，在静态代码块之后执行
		// 每次实例化后都会执行

	static {
		System.out.println("静态代码块");
	}// 静态代码块,最先执行
		// 无论多少次实例化都只会执行一次
		// 1.不可在内调用当前类中的非静态方法，不能使用当前类中的静态属性
		// 2.只能通过对象实例化后调用

	// get/set方法获取或修改私有变量
	// 无get为只写属性
	// 无set为只读属性
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month <= 0) {
			System.out.println("输入信息有误。年龄必须大于0");
		} else {
			this.month = month;
		}

	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

//	public Cat(String name, int month, double weight, String species) {
//		this.name = name;
//		this.month = month;
//		this.weight = weight;
//		this.species = species;
//	}

	// 成员方法：跑动、吃东西
	// 跑动的方法
	public void run() {
		System.out.println("小猫快跑");
	}

	public void run(String name) {
		System.out.println(name + "快跑");
	}

}
