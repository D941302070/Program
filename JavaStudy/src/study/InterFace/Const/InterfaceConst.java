package study.InterFace.Const;

/**
 * 接口中也可以定义“成员变量”,但必须用 public static final修饰
 * 格式：
 * public static final 数据类型 常量名称 = 数据值；
 * final:不可改变
 * <p>
 * 注意事项：
 * 1.可以省略三个修饰符，但不写也是如此
 * 2.接口中的常量必须赋值
 * 3.接口中敞亮的名称，使用完全大写的字母，用下划线分割
 */
public interface InterfaceConst {

    //一旦赋值，不可改变
    public static final int NUM_OF_CLASS = 10;

}
