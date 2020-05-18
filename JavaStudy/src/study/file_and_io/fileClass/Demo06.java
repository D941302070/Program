package study.file_and_io.fileClass;

import java.io.File;

/*
String[] list()返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
File[] listFiles()返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。

注意：
    list方法和listFile方法遍历的是构造方法中给出的目录
    如果构造方法中给出的目录的路径不存在，会抛出空指针异常
    如果构造方法中给出的路径不是一个目录，也会抛出空指针异常
 */
public class Demo06 {
    public static void main(String[] args) {
        show02();
    }

    /*
    File[] listFiles()返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件。
    遍历构造方法中给出的目录，会获取目录中所有文件/文件夹，把获取到的文件/文件夹封装为file对象
     */
    private static void show02() {
        File file = new File("src\\study\\fileClass");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /*
    String[] list()返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录。
    遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称储存到一个String类型的数组中
     */
    private static void show01() {
        File file = new File("src\\study\\fileClass");
        String[] arr = file.list();
        for (String fileName : arr) {
            System.out.println(fileName);
        }
    }
}
