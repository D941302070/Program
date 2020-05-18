package study.exception;
/*
避免finally中写return；
 */
public class Demo09 {
    public static void main(String[] args) {
        int a = getA();
        System.out.println(a);
    }

    //定义一个方法，返回变量a的值
    public static int getA() {
        int a = 10;
        try {
            return a;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //一定会执行
            a = 100;
            return a;
        }
    }
}
