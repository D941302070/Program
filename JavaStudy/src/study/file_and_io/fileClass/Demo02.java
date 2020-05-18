package study.file_and_io.fileClass;

import java.io.File;

/*
路径：
    绝对路径：是一个完整的路径
        以盘符开始的路径
    相对路径：是一个简化的路径
        相对指的是相对于当前项目的根目录
        如果使用当前项目的根目录，可以简化书写

    注意：
        1. 路径不区分大小写
        2. 路径中的文件名称分隔符使用转义字符：//
 */
public class Demo02 {
    public static void main(String[] args) {
        /*
        构造方法
         */
        show03();
    }

    /*
    File(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File实例。
    参数：吧路径分为了两部分
        String parent：父路径
        String child：子路径
    好处：
        父路径和子路径可以单独书写，使用起来更灵活，父路径，子路径都可以变化
        父路径是File类型，可以使用file的方法对路径进行操作，在使用路径创建对象
     */
    private static void show03() {
        File parent = new File("c\\");
        File file = new File(parent,"hello.java");
    }

    /*
    File(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例。
    参数：吧路径分为了两部分
        String parent：父路径
        String child：子路径
    好处：
        父路径和子路径可以单独书写，使用起来更灵活，父路径，子路径都可以变化
     */
    private static void show02(String parent, String child) {
        File file = new File(parent,child);
        System.out.println(file);
    }

    /*
    File(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。

    参数：
        String pathname：字符串的路径名称
        路径可以以文件结尾，也可以用文件夹结尾
        路径可以是想相对路径，也可以是绝对路径
        路径可以存在，也可以不存在
        创建File对象，只是把字符串路径封装为File对象，不考虑路径真假情况
     */
    public static void show01() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\a.txt");
        System.out.println(f1);//重写了toString

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy");
        System.out.println(f2);//重写了toString

        File f3 = new File("b.txt");
        System.out.println(f3);//重写了toString
    }
}
