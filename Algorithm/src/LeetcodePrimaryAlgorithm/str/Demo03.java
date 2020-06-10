package LeetcodePrimaryAlgorithm.str;

import java.util.HashMap;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：

s = "leetcode"
返回 0
s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。
 */
public class Demo03 {
    //官方题解，思路简单，但速度慢
    public static int firstUniqChar1(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] count = new int[26];//计数
        char[] array = s.toCharArray();
        for (char c : array)
            count[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (count[array[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar2("leetcode");
    }
}
