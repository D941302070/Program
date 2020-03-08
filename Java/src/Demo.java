/*
 (人口估算)美国人口调查局基于以下假设进行人口估算:
■每7秒有一个人诞生
■每13秒有一个人死亡
■每45秒有一个移民迁人

编写一个程序，显示未来5年的每年的人口数。假设当前的人口是312032486.每年有365天。
提示: Java中，两个整数相除，结果还是整数，小数部分被去掉。例如，5/4 等于1 (而不是1.25)
，10/4 等于2 (而不是2.5)。如果想得到有小数部分的精确结果，进行除法运算的两个值之一
必须是-一个具有小数点的数值。例如，5.0/4 等于1.25, 10/4.0 等于2.5。

 */
public class Demo {

    public static void main(String[] args) {
        long peopleNumbers = 312032486;
        long oneYearSeconds = 365 * 24 * 60 * 60;
        double oneYearNew = oneYearSeconds / 7.00 + oneYearSeconds / 13.00
                + oneYearSeconds / 45.00;
        for (int i = 1; i <= 5; i++) {
            //peopleNumbers += oneYearNew;
            //System.out.println("第" + i + "年的人数为：" + peopleNumbers);
            System.out.printf("第%d年的人数为：%.2f\n",i,peopleNumbers+i*oneYearNew);
        }
    }
}
