package study.file_and_io.fileClass;

import java.io.File;
import java.util.Scanner;

/*
寻找指定文件后缀
 */
public class Demo08 {
    static String END_NAME;

    public static void main(String[] args) {
        System.out.println("请输入后缀名：");
        END_NAME = "." + new Scanner(System.in).next().toLowerCase();
        getAllFile(new File("C:\\Users\\Administration\\Desktop\\程序"));
    }

    public static void getAllFile(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                getAllFile(f);
            else if (f.getName().toLowerCase().endsWith(END_NAME))
                System.out.println(f);
        }
    }
}
