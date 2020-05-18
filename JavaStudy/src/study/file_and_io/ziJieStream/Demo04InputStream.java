package study.file_and_io.ziJieStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.InputStream:字节输入流，次抽象类是表示字节输入流所有类的超类

定义了所有子类共性的方法
    int read(byte[] b) 从输入流读取一些字节数，并将它们存储到缓冲区 b 。
    int read(byte[] b, int off, int len) 从输入流读取最多 len字节的数据到一个字节数组。
    void close() 关闭此输入流并释放与流相关联的任何系统资源。

java.io.FileInputStream extends InputStream
FileInputStream：文件字节输入流
作用：把硬盘文件的数据读取到内存中
构造方法：
    FileInputStream(File file)
    FileInputStream(String name)
    参数：读取文件的数据源

    构造方法作用：
        1.创建对应
        2.将对象指向要读取的对象

    读取数据的原理：
        java程序-->jvm-->os-->os读取数据的方法-->读取文件

    字节输入流的使用步骤：
        1.创建对象，构造方法中绑定读取的数据源
        2.使用对象的方法read，读取文件
        3.释放资源
 */
public class Demo04InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io流文件测试\\a.txt");
        //int read()：读取文件中的一个字节并返回，读取到文件的末尾返回-1
        int len = 0;//记录已读取的字节
        while ((len = fis.read()) != -1)
            System.out.println((char)len);
        fis.close();
    }
}
