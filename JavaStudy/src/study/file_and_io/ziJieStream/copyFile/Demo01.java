package study.file_and_io.ziJieStream.copyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io流文件测试\\b.txt");

        FileOutputStream fos = new FileOutputStream("io流文件测试\\copyA.txt");;

        //读取多个字节，加快读写效率
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}
