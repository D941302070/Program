package study.map.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
斗地主综合案例：有序版本
1.准备牌
2.洗牌
3.发牌
4.排序
5.看牌
 */
public class Demo {
    public static void main(String[] args) {
        //1.准备牌
        //创建一个Map集合，储存集合的索引和组中号的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建List集合，储存牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，储存花色和牌的序号
        List<String> colors = List.of("♦", "♣", "♥", "♠");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //先储存大王小王
        //定义一个牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;
        //循环嵌套遍历两个集合，组装52张牌，存储到集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }
        //System.out.println(poker);
        //System.out.println(pokerIndex);

        /*
        2.洗牌
        使用Collections中的方法shuffle（List）
         */
        Collections.shuffle(pokerIndex);
        //System.out.println(pokerIndex);

        /*
        3.发牌
         */
        //定义四个集合，储存玩家牌和底牌的索引
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        //遍历储存牌索引的List集合，获取每一个拍的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            //先判断底牌
            if (i >= 51) {
                diPai.add(in);
            } else if (i % 3 == 0) {
                //给玩家1发牌
                player01.add(in);
            } else if (i % 3 == 1) {
                player02.add(in);
            } else {
                player03.add(in);
            }
        }

        /*
        4.排序
        使用Collections中的sort(List)
         */
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);


        lookPoker("玩家1",poker,player01);
        lookPoker("玩家2",poker,player02);
        lookPoker("玩家3",poker,player03);
        lookPoker("底牌",poker,diPai);
    }

    /*
        定义一个看牌的方法，塔高代码的复用性
        参数：
            String name：玩家名称
            HashMap<Integer, String> poker：储存牌的poker集合
            ArrayList<Integer> list：储存玩家和底牌的list集合
        查表法：
            遍历玩家或底牌集合，获取牌的索引
            使用牌的索引，去Map集合里找到对应的牌
         */
    private static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        System.out.print(name + ": ");
        //遍历玩家或底牌集合，获取牌的索引
        for (Integer key : list) {
            String value = poker.get(key);
            System.out.print(value + " ");
        }
        System.out.println();//打印完每一个玩家的牌换行
    }


}