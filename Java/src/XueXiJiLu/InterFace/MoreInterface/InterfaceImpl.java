package XueXiJiLu.InterFace.MoreInterface;

public class InterfaceImpl  implements InterfaceA,InterfaceB{
    @Override
    public void method1() {
        System.out.println("覆盖重写了a方法");
    }

    @Override
    public void method2() {
        System.out.println("覆盖重写了b方法");
    }

    //
    @Override
    public void methodAbs() {
        System.out.println("覆盖重写了A，B中都有的抽象方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("对多个接口当中冲突的默认方法进行覆盖重写");
    }
}
