package XueXiJiLu.Api.hasCode;
/*
哈希值：是一个十进制整数，由系统随机给出（就是对象的地址值，是一个逻辑地址，是模拟出来的地址不是数据实际存储的物理地址）
在Object类里有一个方法，可以获取对象的哈希值
int hashCode() 返回对象的哈希码值
hashCode方法源码：
    public native int hashCode();
    native:代表该方法调用的是本地操作系统的方法
 */
public class Demo01hashCode {
    public static void main(String[] args) {
        Person p1 = new Person();
        int h1 = p1.hashCode();

        Person p2 = new Person();
        int h2 = p2.hashCode();
        /*
        toString方法的源码：
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
         */
        System.out.println(p1);

        /*
        String类的哈希值
            String类重写了Object类的hashCode方法
         */
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println("种地".hashCode());
        System.out.println("通话".hashCode());
    }
}
