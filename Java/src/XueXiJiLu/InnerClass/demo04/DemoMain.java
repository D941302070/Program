package XueXiJiLu.InnerClass.demo04;
/*
如果接口的实现类（或者是父类的子类），止血药使用唯一的一次
那么这种情况下可以省略该类的定义，使用匿名内部类

匿名内部类的定义格式：
接口名称 对象名 = new 接口名称{
    //覆盖重写所有的抽象方法
};

注意：
1.匿名内部类,在创建对象的时候只能使用唯一一次
2.匿名对象，在调用方法的时候只能使用一次
如果希望多次使用，就得给对象取名
3.匿名内部类省略了“实现类/子类”，匿名对象省略了“对象名称”
 */

public class DemoMain {

    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method1();
        //使用匿名内部类
        MyInterface obj=new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法111");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法222");
            }
        };
        obj.method1();
        obj.method2();

        System.out.println("==============");
        //使用了匿名内部类，而且使用了匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法111");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法222");
            }
        }.method1();
    }

}
