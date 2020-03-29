package study.InterFace.Default;


public class Interface02 {

    public static void main(String[] args) {

        //创建实现类对

        InterfaceDefaultA a =new InterfaceDefaultA();
        a.methodAbs();//抽象方法
        a.methoddefault();//默认方法


        System.out.println("===============");


        InterfaceDefaultB b = new InterfaceDefaultB();
        b.methodAbs();//抽象方法
        b.methoddefault();//默认方法
    }

}
