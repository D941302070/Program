package XueXiJiLu.FengZhuang;

//单一职责原则
public class CatTest {
	public static void main(String[] args) {
		// 对象实例化
		Cat one = new Cat();
		one.setName("花花");	
		one.setMonth(0);
		one.setWeight(1000);	
		one.setSpecies("英国短毛猫");
		System.out.println("昵称：" + one.getName());
		System.out.println("年龄：" + one.getMonth());
		System.out.println("体重：" + one.getWeight());
		System.out.println("品种：" + one.getSpecies());
		one.run();
		one.run(one.getName());


	}
}
