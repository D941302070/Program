package study.InterFace.MoreInterface;

public interface InterfaceB {

    public abstract void method2();

    public abstract void methodAbs();

    public default void methodDefault(){
        System.out.println("默认方法bbb");
    }

}
