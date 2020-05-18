package study.file_and_io.fileClass;

import java.io.File;

/*
java.io.File
    文件和目录路径名的抽象表示。
    java把电脑中的文件和文件夹（目录）封装为一个File类，可以使用File类可以对文件和文件夹进行操作
    我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹
        获取文件/文件夹
        判断文件/文件夹是否存在
        遍历文件/文件夹
        获取文件大小
    File类与系统无关，任何操作系统都可以使用这个类


    重点：记住三个单词
        file：文件
        directory：文件夹/目录
        path：路径
 */
public class Demo01 {
    public static void main(String[] args) {
        /*
        static String pathSeparator  与系统相关的路径分隔符字符，为方便起见，表示为字符串。
        static char pathSeparatorChar 与系统相关的路径分隔符。
        static String separator 与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
        static char separatorChar 与系统相关的默认名称分隔符。

        操作路径：路径不能写死了
        C:\.... windows
        C:/.... linux

        "C:"+File.separator+"...."

         */

        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//路径分隔符字符 windows:分号; linux:冒号:

        String separator = File.separator;
        System.out.println(separator);//文件名称分隔符 windows:反斜杠\ linux:正斜杠/
    }
}
