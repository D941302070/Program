package searchArr.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Demo03 {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0) {
                list.add(intervals[i]);
                continue;
            }
            //更新区间
            int len = list.size();
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                //待选区间被包含，跳过
                if (intervals[i][0] > list.get(j)[0] && intervals[i][1] < list.get(j)[1]) {
                    flag = true;
                    break;
                }
                //待选区间左区间比储存左区间小，和大区间包含小区间
                //待选区间右区间比储存右区间大
                if (intervals[i][0] <= list.get(j)[0] && intervals[i][1] >= list.get(j)[0]
                        || intervals[i][1] >= list.get(j)[1] && intervals[i][0] <= list.get(j)[1]) {
                    list.get(j)[1] = intervals[i][1] > list.get(j)[1] ? intervals[i][1] : list.get(j)[1];
                    list.get(j)[0] = intervals[i][0] < list.get(j)[0] ? intervals[i][0] : list.get(j)[0];
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(intervals[i]);
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 4}, {2, 3}};
        merge(a);
    }
}

