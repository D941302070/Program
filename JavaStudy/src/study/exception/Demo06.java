package study.exception;

import java.io.IOException;

/*
    异常处理的第二种方式，自己处理异常
    格式：
        try {
            可能产生异常的代码
        }catch(定义一个异常的变量，怎么处理异常对象){
            异常的处理逻辑，异常之后，怎么处理异常对象
            一般会把异常的信息记录到一个日志中
        }
        ……
        catch(异常类名 变量名){

        }
    注意：
        1. try中可能会抛出多个异常对象，那么就可以使用多个catch来处理这些异常对象
        2. 如果try中产生了异常那么就会执行catch中异常处理逻辑，执行完毕后，继续执行try……catch之后的代码
           如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行完try中的代码后，继续执行try……catch之后的代码

 */
public class Demo06 {
    public static void main(String[] args) {
        try {
            readFile("c:\\\\a.tx");
        } catch (IOException e) {
            System.out.println("catch--传递的文件后缀不是.txt");

            /*
                Throwable类中，定义了三个处理异常的方法
                String getMessage() 返回此throwable的简短描述。
                String toString() 返回此可抛出的详细消息字符串。
                void printStackTrace() JVM打印异常对象默认使用该方法，打印信息最全面
            */

            System.out.println(e.getMessage());//文件后缀名不对
            //重写了toString
            System.out.println(e.toString());//java.io.IOException: 文件后缀名不对
            e.printStackTrace();//一般报错形式
        }
        System.out.println("后续代码");
    }
    public static void readFile(String fileName) throws IOException {

        /*
        如果传递的路径不是.txt结尾
        那么我们就抛出IO异常对象
         */
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件后缀名不对");
        }
    }
}
