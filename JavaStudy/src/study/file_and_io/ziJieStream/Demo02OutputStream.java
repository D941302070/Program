package study.file_and_io.ziJieStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
一次写多个字节的方法：
    void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
    void write(byte[] b, int off, int len) 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流。
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("io流文件测试\\b.txt"));
        /*
        void write(byte[] b) 将 b.length字节从指定的字节数组写入此输出流。
        一次写多个字符：
            如果写的是整数(0~127)，显示时查ASCII表
            如果写的第一个字节是负数，那么第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认的码表(GBK)
         */
        byte[] bytes = {65, 66, 67, 68, 69};//ABCDE
        //byte[] bytes = {-65, -66, -67, 68, 69};//烤紻E
        fos.write(bytes);

        /*
        void write(byte[] b, int off, int len)
            从指定字节数组写入len字节，从偏移 off开始输出到此输出流。
         */
        fos.write(bytes,1,2);//BC

        /*
        写入字符的方法：可以使用String类中的方法，吧字符串转换为字节数组
         */
        fos.write("写入字符串".getBytes());
        fos.close();
    }
}
