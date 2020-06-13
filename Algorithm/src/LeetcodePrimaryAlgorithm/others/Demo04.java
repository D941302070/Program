package LeetcodePrimaryAlgorithm.others;

import java.util.ArrayList;
import java.util.List;

/*
帕斯卡三角形
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Demo04 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return list;

        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        list.add(tem);
        if (numRows == 1) return list;
        tem = new ArrayList<>();
        tem.add(1);
        tem.add(1);
        list.add(tem);
        if (numRows == 2) return list;
        create(3, numRows, tem);
        return list;
    }

    public void create(int floor, int numRows, List<Integer> before) {
        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        for (int i = 1; i <= floor - 2; i++)
            tem.add(before.get(i - 1) + before.get(i));
        tem.add(1);
        list.add(tem);
        if (floor == numRows) return;
        else create(floor + 1, numRows, tem);
    }
}
