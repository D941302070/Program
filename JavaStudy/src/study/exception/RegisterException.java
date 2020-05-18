package study.exception;
/*
自定义异常类
    java提供的异常类，不够我们使用，需要自己定义一些异常类
格式：
    public class XXXException extends Exception/RuntimeException
        添加一个空参构造方法
        添加一个带异常信息构造方法
注意：
    1. 自定义异常类一般都是以Exception结尾，说明是一个异常类
    2. 自定义异常类，必须继承Exception或者RuntimeException
        继承Exception：自定义的异常类是编译期异常，如果方法内部抛出了编译期异常，就必须处理这个异常，要吗throws，要吗try……catch
        继承RuntimeException：自定义的异常类是运行期异常，无需处理，交给虚拟机处理(中断处理)
 */
public class RegisterException extends Exception {
    //添加一个空参构造方法
    public RegisterException() {
    }

    //添加一个带异常信息构造方法
    public RegisterException(String message) {
        super(message);
    }
}
