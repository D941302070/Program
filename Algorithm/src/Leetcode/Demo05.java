package Leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo05 {
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int[] MAX = new int[2];//记录最长长度,两个索引
        for (int mid = 0; mid < s.length() - 1; mid++) {//第一个到倒数第二个，用于确定回文串的中间字符
            /*第一种情况
            偶数回文串，mid为第一个字符，比较下一个字符找到中间的两个字符
            */
            /*第二种情况
            奇数数回文串，mid为中间字符
             */
            int left = mid - 1;
            int right;
            if (s.charAt(mid) == s.charAt(mid + 1)) {
                right = mid + 2;
                MAX = bijiao(mid, s, left, right,MAX);
            }
            if (mid > 0 && (s.charAt(mid - 1) == s.charAt(mid + 1))) {
                right = mid + 1;
                MAX = bijiao(mid, s, left, right,MAX);
            }
        }
        if (MAX[1] == s.length() - 1)
            return s.substring(MAX[0]);
        return s.substring(MAX[0], MAX[1] + 1);
    }

    public static int[] bijiao(int mid, String s, int left, int right,int MAX[]) {
        //左边长度大于右边，右边为终点,反之也考虑
        while (true) {
            if (left < 0 || right >= s.length()) {
                //if ()
                if (right - left - 1 > MAX[1] - MAX[0] + 1) {//越界后长度减
                    MAX[0] = left + 1;
                    MAX[1] = right - 1;
                }
                break;
            }
            if (MAX[1] - MAX[0] >= (s.length() - mid + 1) * 2 + 1)//已找出最长串
                break;

            if (s.charAt(left) != s.charAt(right)) {
                if (right - left - 1 > MAX[1] - MAX[0] + 1) {
                    MAX[0] = left + 1;
                    MAX[1] = right - 1;
                }
                break;
            } else {
                left--;
                right++;
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome(s));

    }
}
