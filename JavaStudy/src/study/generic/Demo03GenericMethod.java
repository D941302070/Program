package study.generic;

public class Demo03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        /*
        调用有泛型的方法method01
        传递什么类型，泛型就是什么类型；
         */
        gm.method1(10);
        gm.method1("sfsds");
        gm.method1(true);
        gm.method1(8.3);

        //静态方法,通过类名.方法名可以直接调用
        gm.method2(2);
        GenericMethod.method2("fef");
    }
}
