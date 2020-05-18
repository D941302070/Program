package study.file_and_io.fileClass;

import java.io.File;
import java.io.IOException;

/*
boolean createNewFile() 当且仅当具有该名称的文件尚不存在时，原子地创建一个由该抽象路径名命名的新的空文件。
boolean delete() 删除由此抽象路径名表示的文件或目录。
boolean mkdir() 创建由此抽象路径名命名的目录。
boolean mkdirs() 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录。
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        show03();
    }

    /*
    boolean delete() 删除由此抽象路径名表示的文件或目录。
    可以删除构造方法的文件或文件夹
    返回值：
        true：文件\文件夹删除成功
        false：文件夹中有内容，不会删除返回false；构造方法中路径不存在返回false

    注意：
        delete是直接在硬盘中删除文件/文件夹，不走回收站
     */
    private static void show03() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\src\\study\\fileClass\\1.txt");
        System.out.println(f1.delete());
    }

    /*
    boolean mkdir() :创建单级文件夹
    boolean mkdirs() :既可以创建单级文件夹，又可以创建多级文件夹
    创建文件夹的路径和名称在构造方法中给出（构造方法的参数）
    返回值：
        true：文件夹不存在，创建文件夹，返回true
        false：文件存在夹，不创建文件夹，返回false路径不存在也返回false

    注意：
        1.只创建文件夹，不创建文件
        2.创建文件的路径必须存在，否则抛出异常
     */
    private static void show02() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\src\\study\\fileClass\\aaa");
        System.out.println(f1.mkdir());

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\src\\study\\fileClass\\111\\222\\1");
        System.out.println(f2.mkdirs());

        File f3 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\src\\study\\fileClass\\abc.txt");
        System.out.println(f3.mkdirs());//会创建同名文件夹
    }

    /*
    boolean createNewFile() 当且仅当具有该名称的文件尚不存在时，原子地创建一个由该抽象路径名命名的新的空文件。
    创建文件的路径和名称在构造方法中给出（构造方法的参数）
    返回值：
        true：文件不存在，创建文件，返回true
        false：文件存在，不创建文件，返回false

    注意：
        1。只创建文件，不创建文件夹
        2.创建文件的路径必须存在，否则抛出异常
        3.调用方法必须处理异常
     */
    private static void show01() throws IOException {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\src\\study\\fileClass\\1.txt");
        boolean b1 = f1.createNewFile();
        System.out.println("b1:"+b1);
    }
}
