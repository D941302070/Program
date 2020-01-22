package XueXiJiLu.Api.wrapperClass;

/*
自动装箱与自动拆箱：基本类型的数据包装类之间可以自动的相互相互转换
JDK1.5后出现的新特性
 */
public class Demo02Integer {
    public static void main(String[] args) {
        /*
        自动装箱：直接把int类型的整数赋值给包装类
        Integer in = 1;相当于Integer in = new Integer(1);
         */
        Integer in = 1;

        /*
        自动拆箱:in是包装类，无法直接参与运算，可以自动转换为基本数据类型再进行运算
        in+2就相当于in.intValue()+2;
        in = in.intValue() + 2 = 3;
         */
        in = in + 2;
    }
}
