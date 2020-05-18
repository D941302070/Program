package study.file_and_io.Filter;

import java.io.File;
import java.io.FilenameFilter;

/*
File[] listFiles(FileFilter filter) 返回一个抽象路径名数组，表示由此抽象路径名表示的满足指定过滤器的目录中的文件和目录。
FileFilter接口：用于抽象路径名（File）的过滤器
    抽象方法：boolean accept(File pathname) 测试指定的抽象路径名是否应包含在路径名列表中。
             参数：File pathname：使用listFiles方法遍历目录，得到的每一个文件对象

File[] listFiles(FilenameFilter filter) 返回一个抽象路径名数组，表示由此抽象路径名表示的满足指定过滤器的目录中的文件和目录。
FilenameFilter接口：实现此接口的类的实例用于过滤文件名。
    抽象方法：boolean accept(File dir, String name) 测试指定文件是否应包含在文件列表中。
              参数：
                File dir：构造方法中传递的目录
                String name：listFiles遍历目录获取的没有个文件或文件夹的名称

注意事项：两个过滤器接口都没有实现类，需要自己写实现类，重写过滤的方法，在方法中自己定义过滤规则
 */
public class Demo02 {
    public static void main(String[] args) {
        getAllFile(new File("src"));
    }

    /*
        定义一个方法。参数传递File类型的目录
     */

    public static void getAllFile(File dir) {
        System.out.println(dir);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });
        for (File f : files) {
            if (f.isDirectory())
                getAllFile(f);
            else System.out.println(f);
        }
    }
}
