package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*
315. 计算右侧小于当前元素的个数
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例:

输入: [5,2,6,1]
输出: [2,1,1,0]
解释:
5 的右侧有 2 个更小的元素 (2 和 1).
2 的右侧仅有 1 个更小的元素 (1).
6 的右侧有 1 个更小的元素 (1).
1 的右侧有 0 个更小的元素.
 */
public class Demo315 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                list.add(nums[i]);
                res.add(0, 0);
            } else {
                //search
                int ind = binaryS(list, nums[i]);
                list.add(ind, nums[i]);
                res.add(0, ind);

            }
        }
        return res;
    }

    //边界二叉搜索
    public int binaryS(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
