package study.file_and_io.fileClass;

import java.io.File;

/*
boolean exists() 测试此抽象路径名表示的文件或目录是否存在。
boolean isDirectory() 测试此抽象路径名表示的文件是否为目录。
boolean isFile() 测试此抽象路径名表示的文件是否为普通文件。
 */
public class Demo04 {
    public static void main(String[] args) {
        show02();
    }

    /*
    boolean isDirectory() 测试此抽象路径名表示的文件是否为目录。
        用于判断构造方法中给定的路径是否以文件夹结尾
            是：true
    boolean isFile() 测试此抽象路径名表示的文件是否为普通文件。
        用于判断构造方法中给定的路径是否以文件结尾
            是：true

    注意：
        硬盘只有文件和文件夹，两个方法互斥
        方法使用前提，路径必须存在，否则都返回false
     */
    private static void show02() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\Jav");
        //不存在不获取
        if (f1.exists()) {
            System.out.println(f1.isDirectory());
            System.out.println(f1.isFile());
        }

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy");
        if (f2.exists()) {
            System.out.println(f2.isDirectory());
            System.out.println(f2.isFile());
        }
    }

    /*
    boolean exists() 测试此抽象路径名表示的文件或目录是否存在。
    用于判断构造方法中的路径是否存在
        存在：true
     */
    private static void show01() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy");
        System.out.println(f1.exists());//true

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStud");
        System.out.println(f2.exists());//false
    }
}
