package study.file_and_io.fileClass;

import java.io.File;

/*
递归打印多级目录
 */
public class Demo07 {
    public static void main(String[] args) {
        getAllFile(new File("src"));
    }

    /*
        定义一个方法。参数传递File类型的目录
     */

    public static void getAllFile(File dir){
        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                getAllFile(f);
            else System.out.println(f);
        }
    }
}
