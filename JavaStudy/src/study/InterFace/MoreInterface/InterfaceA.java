package study.InterFace.MoreInterface;

public interface InterfaceA {

    public abstract void method1();

    public abstract void methodAbs();

    public default void methodDefault(){
        System.out.println("默认方法aaa");
    }

}
