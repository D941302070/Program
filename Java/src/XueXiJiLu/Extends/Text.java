package XueXiJiLu.Extends;

public class Text {


	public static void main(String[] args) {
		Cat one = new Cat();
		one.setName("花花");
		one.setSpecie("中华田园猫");
		one.eat();
		one.run();
		System.out.println("======================");
		Dog two = new Dog();
		two.setName("妞妞");
		two.setMonth(1);
		two.eat();
		two.sleep();

		boolean flag = one.equals(two);
		System.out.println(flag);
		System.out.println("======================");
		System.out.println(one.toString());
		System.out.println(one);
		System.out.println("======================");
		System.out.println(one.getClass());
		System.out.println("======================");
		System.out.println(one.hashCode());
	}

}
