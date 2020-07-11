package Leetcode;

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Demo63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*f(i,j) = f(i-1,j)+f(i,j-1)  i,j无障碍物
                   0
        因为每个格子只与当前行的左格子和上一行的当前列有关，所以dp数组只需要一行
         */
        //m行n列
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //有障碍物
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                    //最左边一列始终只有上面格子一种情况，所以不用更新值
                else if (j >= 1) dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
