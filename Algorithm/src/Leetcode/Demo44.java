package Leetcode;
/*
44. 通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输出: false
 */
public class Demo44 {
    public boolean isMatch(String s, String p) {
        /*
        dp[i][j]=
                dp[i−1][j−1]    si与 pj相同或者 pj是问号
                dp[i][j−1]∨dp[i−1][j]    pj是星号
                False    其他情况
        dp[0][0]=True，即当字符串 s 和模式 p 均为空时，匹配成功；
        dp[i][0]=False，即空模式无法匹配非空字符串；
        dp[0][j] 需要分情况讨论：因为星号才能匹配空字符串，
        所以只有当模式 p 的前 j 个字符均为星号时，dp[0][j]dp[0][j] 才为真。
         */
        int m = s.length();
        int n = p.length();
        char[] sArr = s.toCharArray(),pArr = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i)
            if (pArr[i - 1] == '*')
                dp[0][i] = true;
            else
                break;
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (pArr[j - 1] == '?' || sArr[i - 1] == pArr[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
        return dp[m][n];
    }
}
