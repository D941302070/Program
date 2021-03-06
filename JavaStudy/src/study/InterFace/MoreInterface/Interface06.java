package study.InterFace.MoreInterface;

/**
 * 注意：
 * 1.一个接口里没有静态代码块或者构造方法
 * 2.一个类的父类是唯一的，但一个类可以同时实现多个接口
 * <p>
 * 格式：
 * public class 类名称 implements 接口a，接口b{
 * //覆盖重写所有的抽象方法
 * }
 * <p>
 * 3.如果两个接口抽象方法重名，秩序重写一次
 * 4.如果实现类没有覆盖重写接口中的所有抽象方法，那么实现类必须是一个抽象类
 * 5.如果实现 类实现的多个接口当中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行覆盖重写
 * 6.一个类如果父类中的方法和接口中的默认方法发生了冲突，优先用父类中的方法
 */
public class Interface06 {

}
