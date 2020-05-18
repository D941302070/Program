package study.file_and_io.ziJieStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
字节输入流依次读取多个字节的方法
    int read(byte[] b) 从输入流读取最多 len字节的数据到一个字节数组。
    参数：
        b：起缓冲作用，储存读取的结果
        返回值：读取有效的字节个数

 */
public class Demo05InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io流文件测试\\b.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }
}
