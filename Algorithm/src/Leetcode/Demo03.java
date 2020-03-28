/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode;

public class Demo03 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        int MAX_LENGTH = 0;
        int[] flag = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            flag[i] = -1;
        }
        for (int i = 0; i < s.length() - 1; i++) {//找到最近的相同字母
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag[j] = i;
                    break;
                }
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {//外层按顺序遍历字符串开始
            if (MAX_LENGTH == s.length() - i + 1) {
                return MAX_LENGTH;
            }
            for (int j = i + 1; j < s.length(); j++) {//寻找相同串
                if (flag[j] >= i) {//i之后的字符有相等的，去第一次出现
                    if (MAX_LENGTH < j - i) {
                        MAX_LENGTH = j - i;
                        break;
                    } else break;
                }
                /*if (flag[j] > i) {//i之后的字符有相等的，去第一次出现
                    if (MAX_LENGTH < j - i) {
                        MAX_LENGTH = j - i;
                        break;
                    } else break;
                }
                if (flag[j] == i) {//首字符相等。去中间长度
                    if (MAX_LENGTH < j - i) {
                        MAX_LENGTH = j - i;
                        break;
                    } else break;

                }*/
                if (j == s.length() - 1 && MAX_LENGTH < j - i + 1) MAX_LENGTH = j - i + 1;
            }
        }
        return MAX_LENGTH;
    }

    public static void main(String[] args) {
        String a = "abcb";
        System.out.println(lengthOfLongestSubstring(a));
    }
}