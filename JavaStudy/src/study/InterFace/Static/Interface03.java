package study.InterFace.Static;


/**
 * 注意事项：不能通过接口实现类对象来调用接口当中的实现方法
 *
 * 正确用法：通过接口名称直接调用静态方法
 */
public class Interface03 {

    public static void main(String[] args) {
        //创建实现类对象
        InterfaceStaticImpl impl = new InterfaceStaticImpl();

        //错误写法
        //impl.methodStatic();

        //直接通过接口名称调用静态方法
        InterfaceStatic.methodStatic();

    }

}
