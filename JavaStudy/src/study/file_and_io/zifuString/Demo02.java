package study.file_and_io.zifuString;

import java.io.FileWriter;
import java.io.IOException;

/*
java.io.Writer ：字符输出流，是所有字符输出流的最顶层父类，是一个抽象类

共性的成员方法：
    abstract void close() 关闭流，先刷新。
    abstract void flush() 刷新流。
    void write(char[] cbuf) 写入一个字符数组。
    abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分。
    void write(int c) 写一个字符
    void write(String str) 写一个字符串
    void write(String str, int off, int len) 写一个字符串的一部分。

java.io.FileWriter extends OutputStreamWriter extends Writer
FileWriter：文件字符输出流
作用：把内存中的字符数据写入到文件中

构造方法：
    FileWriter(File file) 给一个File对象构造一个FileWriter对象。 。
    FileWriter(String fileName) 构造一个给定文件名的FileWriter对象。
    参数：写入数据的目的地

    构造方法的作用：
        1.创建对象
        2.根据构造方法传递文件\文件夹的路径，创建文件
        3.对象指向文件

    使用步骤：
        1.创建对象，构造方法中绑定目的地
        2.使用write，吧数据写入到内存缓冲区中（字符转换为字节）；
        3.使用flush，把内存缓冲区的数据，刷新到文件中
        4.释放资源（先把内存把内存缓冲区的数据，刷新到文件中，然后释放）
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("io流文件测试\\d.txt");

        fw.write(97);

        fw.flush();//可以不写

        fw.close();
    }
}
