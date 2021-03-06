package LeetcodePrimaryAlgorithm.str;

/*
最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class Demo07 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        StringBuffer str = new StringBuffer();
        int minLen = strs[0].length(), len = strs.length;
        for (int i = 1; i < len; i++)
            minLen = minLen > strs[i].length() ? strs[i].length() : minLen;
        for (int i = 0; i < minLen; i++) {
            char tem = strs[0].charAt(i);
            for (int j = 1; j < len; j++)
                if (strs[j].charAt(i) != tem) return str.toString();
            str.append(tem);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        longestCommonPrefix(a);

    }
}
