package XueXiJiLu.Extends.RedEnvelopes;

import java.util.ArrayList;
import java.util.Random;

//普通成员
public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list) {
        //从多个红包抽取一个，给自己
        //随机获取一个集合当中的所以编号
        int index = new Random().nextInt(list.size());
        //根据索引，从集合中删除，并且得到被删除的红包
        int delta = list.remove(index);
        //当前成员有多少钱
        int money = super.getMoney();
        //加法，重新设置回去
        super.setMoney(money + delta);


        //super.setMoney(list.remove(new Random().nextInt(list.size()))+super.getMoney());
    }
}
