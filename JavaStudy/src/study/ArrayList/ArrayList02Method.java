package XueXiJiLu.Api.ArrayList_api;

import java.util.ArrayList;

/**
 * ArrayList常用api
 * 注：对于ArrayList集合，add添加动作一定成功，返回值可用可不用
 * 对于其它集合，add方法不一定成功
 */
public class ArrayList02Method {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        boolean flag = list.add("段星雨");
        System.out.println(flag);
        list.add("李华");
        list.add("小明");
        list.add("小刚");

        //get方法，获取ArrayList中的元素，返回值为对象
        String name3 = list.get(2);
        System.out.println("2号的对昂为" + name3);

        //remove方法，删除元素，返回值为删除的对象
        String whoRemove = list.remove(2);
        System.out.println("被删除的元素为："+ whoRemove);

        //size方法，获取集合长度
        int size=list.size();
        System.out.println("集合长度为："+size);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

