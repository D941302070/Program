package study.InterFace.Abstract;

/**
 * 接口
 * <p>
 * <p>
 * java7，接口中包含的内容有：
 * 1.常量
 * 2.抽象方法
 * <p>
 * java8，可以额外包括
 * 3.默认方法
 * 4.静态方法
 * <p>
 * java9可以额外包括
 * 5.私有方法
 * <p>
 * <p>
 * 定义抽象方法的基本格式：
 * public abstract 返回值类型 方法名称（参数列表）；
 *
 * 注：
 * 1.借口当中的抽象方法修饰符必须是固定的关键字，public abstract
 * 2.这两个人修饰关键字可以省略
 * 3.方法三要素可以随便定义
 *
 *
 * 借口使用步骤
 * 1.借口不能直接使用，必须有一个“实现类”来实现该接口
 * 格式：
 * public class 实现类名称 implements 借口名称{
 *     //...
 * }
 * 2.接口的实现类必须覆盖重写（实现）接口中所有的抽象方法.
 * 实现：去掉abstract关键字，加上方法体大括号
 * 3.创建实现类的对象，进行使用
 *
 * 注：
 * 如果实现类比没有覆盖重写接口里所有的抽象类，这个实现类必须是抽象类
 * */
public interface InterFaceAbstract {

    public abstract void methodAbstract1();

    public void methodaAbstract2();

    abstract void methodaAbstract3();

    void methodaAbstract4();

    //以上均为抽象方法

}
