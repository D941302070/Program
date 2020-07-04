package java_exam.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sequence {

    List<Integer> list = new ArrayList<>();
    int len;

    public void read() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //String会占用每次修改都会占用过多的缓冲区空间，StringBuffer则不会
        StringBuffer sb = new StringBuffer();
        //使用charAt会占用跟多时间，将字符串转化为数组速度跟快
        for (char c : str.toCharArray())
            if (c == ',') {
                list.add(Integer.parseInt(sb.toString()));
                sb = new StringBuffer();
            } else sb.append(c);
        //最后一次未录入
        list.add(Integer.parseInt(sb.toString()));
        len = list.size();
    }

    public void reversal() {
        //每次交换i和中心对称的元素
        for (int i = 0; i < len / 2; i++) {
            int tem = list.get(i);
            list.set(i, list.get(len - 1 - i));
            list.set(len - 1 - i, tem);
        }
    }

    public void sort() {
        //冒泡排序
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1 - i; j++)
                if (list.get(j) > list.get(j + 1)) {
                    int tem = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tem);
                }
    }

    public double average() {
        double avg = 0;
        for (int i = 0; i < len; i++)
            avg += list.get(i);
        return avg / len;
    }

    public int nearAvg() {
        //index记录索引，dif记录数字与平均值的差值
        int index = 0;
        double avg = average(), dif = Math.abs(avg - list.get(0));
        for (int i = 1; i < len; i++)
            if (Math.abs(avg - list.get(i)) < dif) {
                //更新新的值
                dif = Math.abs(avg - list.get(i));
                index = i;
            }
        return index;
    }
}
