package study.InterFace.Default;

/**
 * 从java8开始，接口里如需定义默认方法
 * 格式：
 * public default 返回值类型 方法名称（参数列表）{
 * 方法体
 * }
 * <p>
 * <p>
 * 备注：接口当中的默认方法，可以解决接口升级的问题
 *
 * 注：
 * 1.接口的默认方法，可以通过接口类对象，直接调用
 * 2.接口的默认方法，也可被接口实现类进行覆盖重写
 */
public interface InterfaceDefault {

    public abstract void methodAbs();

    public default void methoddefault() {
        System.out.println("新添加的默认方法");
    }

}
