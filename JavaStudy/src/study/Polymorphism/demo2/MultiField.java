package XueXiJiLu.Polymorphism.demo2;
/*
访问变量的两种方法：
1.直接通过对象名访问变量：看等号左边是谁，有限用谁，找不到则向上找
2.简介通过成员方法访问:     该方法属于谁,优先用谁,没有则向上找
 */
public class MultiField {

    //使用多态写法
    public static void main(String[] args) {

        Fu obj = new Zi();
        System.out.println(obj.num);
        //System.out.println(obj.age);错误写法
        System.out.println("========");

        //子类没有覆盖重写：父：10
        //子类覆盖重写：子：20
        obj.shownum();//子类覆盖重写

    }

}
