package study.file_and_io.Properties_class;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
    java.util.Properties 集合，extend HashTable<k,v> implements Map<k,v>
    Properties类表示一组持久的属性。 Properties可以保存到流中或从流中加载。
    Properties集合是一个唯一和IO流相结合的集合
        可以使用properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        可以使用properties集合中的方法load，吧硬盘中的文件（键值对），读取到集合中使用

    属性列表中的每个键及其对应的值都是一个字符串。
        properties集合是一个双列集合，key和value默认都是字符串
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        show03();
    }

    /*
    可以使用properties集合中的方法load，吧硬盘中的文件（键值对），读取到集合中使用
    void load(InputStream inStream)
    void load(Reader reader)
    参数：
        InputStream inStream：字节输入流，不能读取含有中文的键值对
        Reader reader：字符输入流，可以读取含有中文的键值对
    使用步骤：
        1.创建对象
        2.load方法读取保存键值对的文件
        3.遍历集合
    注意：
        1.储存键值对的文件中，key与默认值的连接符号可以使用=，空格（其他符号）
        2.储存键值对的文件中，可以使用#注释，被注释的不会读取
        3.储存键值对的文件中，key与默认值的都是字符串，不用加引号
     */
    private static void show03() throws IOException {
        //1.创建对象
        Properties prop = new Properties();

        //2.load方法读取保存键值对的文件
        prop.load(new FileReader("io流文件测试\\prop.txt"));

        //3.遍历集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /*
    可以使用properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
    void store(OutputStream out, String comments)
    void store(Writer writer, String comments)
    参数：
        OutputStream out：字节输出流，不能写中文
        Writer writer：字符输出流，可以写中文
        String comments：注释，用来解释说明保存文件是做什么用的
            不能使用中文，会产生乱码，默认使用Unicode编码
            一般用""
    使用步骤：
        1.创建对象，添加数据
        2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        3.使用properties集合中的方法store，把把集合中的临时数据，持久化写入到硬盘中存储
        4.释放资源
     */
    private static void show02() throws IOException {
        //1.创建对象，添加数据
        Properties prop = new Properties();
        prop.setProperty("小明", "168");
        prop.setProperty("小刚", "165");
        prop.setProperty("小吕", "178");

        //2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        //FileWriter fw = new FileWriter("io流文件测试\\prop.txt");

        //3.使用properties集合中的方法store，把把集合中的临时数据，持久化写入到硬盘中存储
        //prop.store(fw,"save data");

        //4.释放资源
        //fw.close();

        prop.store(new FileOutputStream("io流文件测试\\prop.txt"), "");
    }

    /*
    使用properties集合存储数据，遍历取出 properties集合中的数据
    properties集合是一个双列集合，key和value默认都是字符串
    properties集合中有一些操作字符串的特有方法

        Object setProperty(String key, String value) 调用 Hashtable方法 put 。
        String getProperty(String key) 通过key找value，此方法相当于Map中的get方法
        Set<String> stringPropertyNames() 返回此属性列表中的一组键，其中键及其对应的值为字符串，此方法相当于Map中的keySet方法
     */
    private static void show01() {
        //创建对象
        Properties prop = new Properties();
        //使用setProperty往集合中天添加元素
        prop.setProperty("小明", "168");
        prop.setProperty("小刚", "165");
        prop.setProperty("小吕", "178");

        //使用stringPropertyNames把properties集合中的key取出，储存到一个set集合
        Set<String> set = prop.stringPropertyNames();

        //遍历,取出每一个key
        for (String key : set) {
            //使用getProperty方法使用key获取value
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}
