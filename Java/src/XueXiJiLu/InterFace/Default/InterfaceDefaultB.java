package XueXiJiLu.InterFace.Default;

public class InterfaceDefaultB implements InterfaceDefault {
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法B");
    }

    @Override
    public void methoddefault() {
        System.out.println("重写默认方法");
    }

}
