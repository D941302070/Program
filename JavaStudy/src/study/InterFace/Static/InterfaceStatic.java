package study.InterFace.Static;

/**
 * 从java8开始，接口中允许定义静态方法
 *
 * public static 返回值类型 方法名称（参数列表）{
 *     方法体
 * }
 *
 * 提示：就是将abstract货值default换成static，带上方法体
 */
public interface InterfaceStatic {

    public static void methodStatic(){
        System.out.println("这是接口的静态方法");
    }

}
