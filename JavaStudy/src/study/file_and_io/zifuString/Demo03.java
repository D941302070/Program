package study.file_and_io.zifuString;

import java.io.FileWriter;
import java.io.IOException;

/*
flush和close的方法

    flush：刷新缓冲区，流对象可以继续使用
    close：先刷新缓冲区，然后通知系统释放资源，流对象不可使用
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("io流文件测试\\e.txt");

        fw.write(97);

        fw.flush();

        fw.write(98);

        fw.close();
    }
}
