package XueXiJiLu.Api.Object;

import java.util.Objects;

public class demo03_objects {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "'abc";
        //boolean b = s1.equals(s2);

        /*
        Object类中的equals方法：对两个对象进行比较，防止空指针异常
        public static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        }
         */
        boolean b2 = Objects.equals(s1, s2);
        System.out.println(b2);

    }
}
