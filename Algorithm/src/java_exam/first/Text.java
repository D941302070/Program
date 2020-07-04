package java_exam.first;

public class Text {
    public static void main(String[] args) {
        Sequence s = new Sequence();
        //读取数列
        s.read();
        System.out.println(s.list);
        //求平均值
        System.out.println("avg = " + s.average());
        //翻转
        s.reversal();
        System.out.println("翻转：" + s.list);
        //排序
        s.sort();
        System.out.println("排序：" + s.list);
        //找到最接近平均值的数
        int nearAvg = s.nearAvg();
        System.out.println("找到最接近平均值的索引为：" + nearAvg + "，值为" + s.list.get(nearAvg));
    }
}
