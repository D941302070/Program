import	java.util.ArrayList;

public class text {

    public static void main(String[] args) {
        ArrayList<Long> chushi = new ArrayList<>();
        ArrayList<Long> yushu = new ArrayList<>();
        chushi.add(1L);//1号元素
        chushi.add(1L);//2号元素
        for(int i=2;i<50;i++) {
            chushi.add(chushi.get(i-1)+chushi.get(i-2));
        }
        for(int i=0;i<chushi.size();i++){
            yushu.add(chushi.get(i)%3);
        }
        System.out.println("第100个数对三求余为："+yushu.get(100%8-1));
        System.out.println("第200个数对三求余为："+yushu.get(100%8-1));
    }

}
