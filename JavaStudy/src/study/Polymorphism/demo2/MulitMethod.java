package study.Polymorphism.demo2;
/*
多态中成员方法的使用规则：
    看new的是谁就优先是谁，没有则向上找

    口诀：编译看左边，运行看右边
    编译看左边是否存在，运行先运行右边
 */
public class MulitMethod {

    public static void main(String[] args) {
        Fu obj = new Zi();//多态
        obj.method();//父子都有,有限用子
        obj.methodFu();//子类没有，父类有，向上找到父类进行使用
        //obj.methZi();//编译报错

    }

}
