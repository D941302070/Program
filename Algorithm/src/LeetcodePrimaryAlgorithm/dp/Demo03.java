package LeetcodePrimaryAlgorithm.dp;

/*
最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Demo03 {
    public int maxSubArray(int[] nums) {
        //dp[n]表示以n结尾的最大连续数组和
        //dp[n] = max(dp[n - 1]+nums[n], nums[n])
        int preMax = 0, max = nums[0];
        //preMax储存dp[n-1]，储存最终的结果
        for (int tem : nums) {
            preMax = Math.max(preMax + tem, tem);
            max = Math.max(preMax, max);
        }
        return max;
    }
}
