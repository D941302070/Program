package XueXiJiLu.Api.wrapperClass;
/*
装箱：把基本类型的数据，包装到包装类中（基本类型的数据->包装类）
    构造方法：
        Integer(int value) 构造一个新分配的 Integer对象，该对象表示指定的 int值。
        Integer(String s) 构造一个新分配 Integer对象，表示 int由指示值 String参数。
            传递的字符串，必须是基本类型的字符串，否则会抛出异常
    静态方法：
        static Integer valueOf(int i) 返回一个 Integer指定的 int值的 Integer实例。
        static Integer valueOf(String s)返回一个 Integer对象，保存指定的值为 String

拆箱：在包装类中取出基本类型的数据(包装类->基本类型数据)
    成员方法：
    int intValue() 将 Integer的值作为 int 。
 */

public class Demo01Integer {


        public static void main(String[] args) {
            //装箱：把基本类型的数据，包装到包装类中（基本类型的数据->包装类）
            //构造方法：
            Integer in1 = new Integer(43);
            System.out.println(in1);

            Integer in2 = new Integer("37478");
            System.out.println(in2);

            //静态方法
            Integer in3 = Integer.valueOf("323");
            System.out.println(in3);

            Integer in4 = Integer.valueOf(23);
            System.out.println(in4);

            //拆箱
            int i = in1.intValue();
        }
}
