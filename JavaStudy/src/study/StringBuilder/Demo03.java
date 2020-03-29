package study.StringBuilder;
/*
StringBuild和String可以相互转换；
    String->StringBuilder：可以使用StringBuilder
        public StringBuilder(String str)：构造一个StringBuilder容器，并将字符串添加进去,并初始化为指定的字符串内容。
    StringBuilder->String：可以使用StringBuilder中的toString方法
        public String toString()：将当前StringBuilder对象转换为String对象
 */
public class Demo03 {
    public static void main(String[] args) {
        //String->StringBuilder
        String str = "hello";
        StringBuilder bu = new StringBuilder(str);
        //往StringBuild中添加数据
        bu.append("world");
        System.out.println(bu);

        // StringBuilder->String
        String str2 = bu.toString();
        System.out.println(str2);
    }
}
