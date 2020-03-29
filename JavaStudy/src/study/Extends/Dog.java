package study.Extends;

public class Dog extends Animal {
	private String sex;

	public Dog() {


	}

	public String getSex() {

		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void sleep() {
		System.out.println(this.getName() + "现在是" + this.getMonth() + "月大的狗，正在睡觉");
	}

	public void eat() {
		System.out.println(this.getName()+"最近没有食欲");
	}
}
