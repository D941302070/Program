package study.file_and_io.fileClass;

import java.io.File;

/*
public String getAbsolutePath() ：返回此File的绝对路径名字符串。
public String getPath() ：将此File转换为路径名字符串。
public String getName() ：返回由此File表示的文件或目录的名称。
public long length() ：返回由此File表示的文件的长度。
 */
public class Demo03 {
    public static void main(String[] args) {
        show04();
    }

    /*
    public long length() ：返回由此File表示的文件的长度。
    获取的是构造方法的文件的大小，以字节为单位
    注意：
        文件夹没有大小概念，不能获取文件夹大小
        如果构造方法中给出的路径不存在，那么length返回0
     */
    private static void show04() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\JavaStudy.iml");
        System.out.println(f1.length());//字节为单位

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\1.txt");
        System.out.println(f2.length());//字节为单位

        File f3 = new File("C:");
        System.out.println(f3.length());//字节为单位
    }

    /*
    public String getName() ：返回由此File表示的文件或目录的名称。
    获取构造方法的结尾部分(文件/文件夹)
     */
    private static void show03() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\a.txt");
        System.out.println(f1.getName());//a.txt

        File f2 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy");
        System.out.println(f2.getName());//JavaStudy
    }

    /*
    public String getPath() ：将此File转换为路径名字符串。
    获取构造方法中传递的路径

    toString调用getPath
     */
    private static void show02() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\a.txt");
        System.out.println(f1.getPath());

        File f2 = new File("a.txt");
        System.out.println(f2.getPath());

        System.out.println(f1.toString());
    }

    /*
    public String getAbsolutePath() ：返回此File的绝对路径名字符串。
    获取构造方法中传递的路径
    无论是相对还是绝对，getAbsolutePath返回的都是绝对路径
     */
    private static void show01() {
        File f1 = new File("C:\\Users\\Administration\\Desktop\\程序\\JavaStudy\\a.txt");
        System.out.println(f1.getAbsoluteFile());

        File f2 = new File("a.txt");
        System.out.println(f2.getAbsoluteFile());
    }
}
