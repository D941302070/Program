package study.FengZhuang;



/**
 *
 * @author 淺い空
 *
 */
public class Text {

	public static void main(String[] args) {
		Cat one = new Cat();
		one.setName("花花");
		one.setMonth(10);
		one.setSpecies("英国短毛猫");
		//one.price = 2000;回警告
		Cat.price = 3000;// 静态对象既可通过 “类.成员” 访问，也可通过 “对象.成员” 名访问
		Cat.eat();// 静态方法调用
		Cat two = new Cat();
		two.setName("凡凡");
		two.setMonth(1);
		two.setSpecies("中华田园猫");
	}

}
