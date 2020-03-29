package study.InnerClass.demo03;
/*
局部内部类：如果需要访问所在方法的局部变量，那么这个变量必须是有效final的
 */
public class MyOuter {

    public void methodOuter(){
        final int num = 10;//final可以省略，但不能修改num
        class MyInner{
            public void methodInner(){
                System.out.println(num);
            }
        }
    }

}
