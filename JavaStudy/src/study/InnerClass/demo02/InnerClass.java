package study.InnerClass.demo02;

public class InnerClass {

    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.methodInner();
    }

}
