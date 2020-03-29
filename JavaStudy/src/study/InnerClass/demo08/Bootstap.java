package study.InnerClass.demo08;
/*
场景说明：
    红包发出去以后，所有人都有红包，大家抢完了以后，最后一个红包给群主自己
红包分发的策略：
    1.普通红包（平均）：totalMoney/totalCount，余数放在最后一个红包里
    2.手气红包（随机）：最少一分钱，最多不超过平均数的二倍
 */
public class Bootstap {

    public static void main(String[] args) {

        MyRed red = new MyRed("biaoti");

    }

}
