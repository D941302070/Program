package study.file_and_io.zifuString;

import java.io.FileReader;
import java.io.IOException;

/*
java.io.Reader:字符输入流，是字符输入流的最顶层父类，定义了一些共性的成员方法，是一个抽象类

共性的成员方法:
    int read() 读一个字符并返回
    int read(char[] cbuf) 一次读取多个数组将字符读入数组。
    abstract void close() 关闭流并释放与之相关联的任何系统资源。

java.io.FileReader extends InputStreamReader extends Reader
FileReader：文件字符输入流
作用：把硬盘文件弘德属于以字符的方式读取到内存中

构造方法：
    FileReader(File file) 创建一个新的 FileReader ，给出 File读取。
    FileReader(String fileName) 创建一个新的 FileReader ，给定要读取的文件的名称。
    参数：读取文件的数据源

    FileReader构造方法的作用：
        1.创建一个FileReader对象
        2.对象指向要读取的文件

    字符输入流的使用步骤：
    ·1.创建对象，绑定要读取的数据源
    2.使用FileReader对象中的方法read读取文件
    3.释放资源
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("io流文件测试\\b.txt");

        /*
        int len;
        while ((len = fr.read()) != -1) {
            System.out.print((char) len);
        }
        */

        //数组读取
        int len;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }
}
