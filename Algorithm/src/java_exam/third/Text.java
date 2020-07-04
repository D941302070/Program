package java_exam.third;

import java.util.GregorianCalendar;

public class Text {
    public static void main(String[] args) {
        //创建对象
        ArmedPolice ap = new ArmedPolice(10034, "Jackie chan", 3000, "the 7th Brigade of the Armed Police", "the third Police supervisor");
        //格式化日期,获取日期的毫秒值,并修改日期
        GregorianCalendar gc = new GregorianCalendar(2004, 1, 1);
        ap.setDate(gc.getTime());
        //首先算现在的秒数减去工作日期的秒数
        //然后除以2年的秒数，计算修改几次工资
        long count = (System.currentTimeMillis() - ap.getDate().getTime()) / (63072000000L);
        for (long i = 0; i < count; i++)
            ap.Raise();
        System.out.println(ap);
    }
}
