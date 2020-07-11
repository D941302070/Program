package Leetcode;

/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Demo309 {
    public int maxProfit(int[] prices) {
        /*
        第i天结束之后的收益
            dp[i][0]:没有处于冻结期，手里还有股票
            dp[i][1]:处于冻结期，没有股票
            dp[i][2]:没有处于冻结期，没买股票

        dp[i][0]=max(dp[i-1][2]-price[i],dp[i-1][0])  第i天买入了，或i-1天买入i天不变最大值
        dp[i][1]=dp[i-1][0]+prices[i]  第i天卖了股票
        dp[i][2]=max(dp[i-1][1],dp[i-2][2])  i-1天不持有股票，i-1为冷冻,或i-1不为冷冻的最大值

        第n-1天之后（第n天开始）的结果实际上是max(dp[i][0],dp[i][1],dp[i][2])
        前一天持有股票无意义 所以max(dp[i][1],dp[i][2])
        */
        if (prices.length == 0) return 0;
        int f1 = 0, f2 = 0, f0 = -prices[0], n = prices.length;
        for (int i = 1; i < n; i++) {
            int f0tem = Math.max(f2 - prices[i], f0);
            int f1tem = f0 + prices[i];
            int f2tem = Math.max(f1, f2);
            f0 = f0tem;
            f1 = f1tem;
            f2 = f2tem;
        }
        return Math.max(f1,f2);
    }
}
