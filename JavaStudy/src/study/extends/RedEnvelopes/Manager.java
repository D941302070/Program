package XueXiJiLu.Extends.RedEnvelopes;

import java.util.ArrayList;
//群主的类
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        //集合储存若干个红包金额
        ArrayList<Integer> redList = new ArrayList<Integer>();

        //首先看群主多少钱
        int leftMoney = super.getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;//返回空集合
        }

        //扣钱，重新设置余额
        super.setMoney(leftMoney - totalMoney);

        //发红包均分成count
        int avg = totalMoney / count;
        int mod = totalMoney % count;//余数

        //零头抱在一个红包里
        //把红包，放在一个一个集合里
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }

        //最后一个红包
        redList.add(avg + mod);

        return redList;
    }
}
