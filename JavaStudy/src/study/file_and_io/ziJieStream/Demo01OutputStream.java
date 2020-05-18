package study.file_and_io.ziJieStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java.io.OutputStream:此抽象类是表示输出字节流的所有类的超类

定义了一些共享的成员方法：
    void close() 关闭此输出流并释放与此流相关联的任何系统资源。
    void flush() 刷新此输出流并强制任何缓冲的输出字节被写出。
    void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
    void write(byte[] b, int off, int len) 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
    abstract void write(int b) 将指定的字节写入此输出流。

java.io.FileOutputStream extends OutputStream
FileOutputStream:文件字节输出流
作用：把内存中的数据写入到文件中

构造方法：
FileOutputStream(File file) 创建文件输出流以写入由指定的 File对象表示的文件。
FileOutputStream(String name) 创建文件输出流以指定的名称写入文件。
参数：写入数据的目的地
构造方法作用：
    1.创建一个FileOutputStream对象
    2.会根据构造方法中传递的文件/文件路径，创建一个新的文件
    3.会吧FileOutputStream对象指向创建好的文件

写入内存的原理（内存->硬盘）
    java程序-->jvm-->os(操作系统)-->os调用写数据的方法-->把数据写入到文件中

字节输出流的使用步骤：
    1.创建FileOutputStream对象，构造方法中传递目的地
    2.调用FileOutputStream中的方法write，吧数据写入到文件中
    3.释放资源(流使用会占用一定的内存，使用完毕后要把内存清空，提高程序效率)
 */
public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建FileOutputStream对象，构造方法中传递目的地
        FileOutputStream fos = new FileOutputStream("io流文件测试\\a.txt");
        //2.调用FileOutputStream中的方法write，吧数据写入到文件中
        //字节会自动转换为字节
        fos.write(97);
        //3.释放资源(流使用会占用一定的内存，使用完毕后要把内存清空，提高程序效率)
        fos.close();

    }
}
