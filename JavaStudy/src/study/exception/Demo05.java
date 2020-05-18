package study.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    throws关键字：异常处理的第一种方式，交给别人处理
    作用：
        当方法内部抛出异常对象时，那么我们就必须处理这个异常
        可以使用throws关键字处理异常对象，会吧异常对象声明抛出给方法的调用者处理（自己不处理，给别人处理），最终交给jvm处理-->中断处理
    使用格式：在方法声明时使用
        修饰符 返回值类型 方法名(参数列表) throws aaaException, bbbException {
            throw new aaaException("产生原因");
            throw new bbbException("产生原因");
            ……
        }
    注意:
        1. throws关键字必须写在方法声明处
        2. throws关键字后边声明的异常必须是Exception或者是Exception的子类
        3. 方法内部出现多个异常对象，那么throws后边必须也声明多个异常
            如果抛出多个异常对象有子父类关系，那么直接声明父类异常即可
        4. 调用了一个声明抛出的异常，我们必须处理声明的异常
            要吗继续使用throws,交给方法的调用者处理，最终交给jvm
            要吗try……catch自己处理异常
 */
public class Demo05 {
    /*
    FileNotFoundException extends IOException
     */
    public static void main(String[] args) throws IOException {
        readFile("c:\\\\a.txt");
    }
    /*
        定义一个方法，对传递的文件路径进行合法性判断
        如果路径不是"c:\\a.txt"，那么抛出文件找不到异常对象，告知方法调用者
        注意：
            FileNotFoundException是编译异常，抛出就处理
            可以使用throws继续声明FileNotFoundException这个异常
     */

    public static void readFile(String fileName) throws IOException {
        if (!fileName.equals("c:\\\\a.txt")) {
            throw new FileNotFoundException("传递的文件路径不是c:\\\\a.txt");
        }
        /*
        如果传递的路径不是.txt结尾
        那么我们就抛出IO异常对象
         */
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件后缀名不对");
        }
    }
}
