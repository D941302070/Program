package study.file_and_io.ziJieStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    追加写/续写：
        FileOutputStream(File file, boolean append) 创建文件输出流以写入由指定的 File对象表示的文件。
        FileOutputStream(String name, boolean append) 创建文件输出流以指定的名称写入文件。
    参数：
        1.路径
        2.追加写开关，
            true:创建对象不会覆盖源文件，继续在文件末尾写
            false：创建新文件覆盖源文件

        写换行：写换行字母
 */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("io流文件测试\\b.txt",true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好\n".getBytes());
        }
        fos.close();
    }
}
