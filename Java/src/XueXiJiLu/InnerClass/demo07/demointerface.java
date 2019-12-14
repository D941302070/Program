package XueXiJiLu.InnerClass.demo07;

import java.util.ArrayList;
import java.util.List;
/*
证明java.util.List是Arrayliat实现的接口
 */
public class demointerface {

    public static void main(String[] args) {
        //左边是接口名称，右边是实现类名称，这就是多态写法
        List<String> list = new ArrayList<String>();

        List<String> result =addName(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public static List<String> addName(List<String> list){
        list.add("as");
        list.add("dsfd");
        list.add("dfs");
        list.add("dfdf");
        return list;
    }
}
