package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo39 {

}

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
class Solution {

    //路径
    ArrayList<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return result;
    }

    /**
     * @param start:本次开始的索引
     * @param target:本次要找的数的和
     * @param candidates:数组
     */
    public void dfs(int[] candidates, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));//构造方法克隆
        }
        for (int i = start; i < candidates.length; i++) {
            //如果1个数无结果，那么比他小的数也无结果
            if (target - candidates[i] < 0) break;
            path.add(target - candidates[i]);
            dfs(candidates, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}