package study.file_and_io.Filter;

import java.io.File;
import java.io.FileFilter;

/*
创建FileFilter的实现类，重写过滤方法accept，定义过滤规则
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        //过滤规则
        //如果是文件夹，返回true，结尾正确返回true
        if (pathname.isDirectory()) return true;
        return pathname.getName().toLowerCase().endsWith(".java");
    }
}
