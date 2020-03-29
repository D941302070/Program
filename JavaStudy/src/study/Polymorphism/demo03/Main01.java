package study.Polymorphism.demo03;
/*
对象的向上转型就是多态写法
格式：父类名称 对象名 = new 子类对象();
含义：右侧创建了一个子类对象把他当做父类使用
注意事项：向上转型一定是安全的，小范围转向了大范围
但是一旦向上转型为父类，就无法使用子类特有的方法

对象的向下转型
格式：子类名称 对象名=（子类对象）父类名称；
含义：将父类对象还原为之前的子类对象
注意事项：对象必须是猫才能向下转型为猫
 */
public class Main01 {

    public static void main(String[] args) {

        //对象的向上转型就是，父类引用指向子类对象
        Animal animal = new Cat();
        animal.eat();
        //animal.catchmouse;//编译报错

        Cat cat = (Cat) animal;
        cat.catchmouse();

        //错误转型
        Dog dog = (Dog) animal;//编译不报错，运行出现异常

    }

}
