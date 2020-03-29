package study.InnerClass.demo03;

/*
如果一个类实在方法内部中定义的，娜美这就是一个局部内部类
只有当前方法才能使用他，除了方法就不能使用

定义格式：
修饰符 class 外部类名称{
    修饰符 返回值类型 外部类方法名称（参数列表）{
        class 局部内部类名称{
            //...
        }
    }

}
 */
public class Outer {

    public void methodOuter() {
        class Inner {
            int num = 10;
            public void methodInner(){
                System.out.println(num);
            }
        }
        Inner inner =new Inner();
        inner.methodInner();
    }

}
