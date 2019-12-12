package XueXiJiLu.Polymorphism.demo2;

public class Zi extends Fu {

    int num= 20;
    int age = 6;

    @Override//覆盖重写父类方法
    public void shownum() {
        System.out.println(num);
    }

    @Override
    public void method() {
        System.out.println("子类方法");
    }

    public void methodzi() {
        System.out.println("子类特有方法");
    }
}
