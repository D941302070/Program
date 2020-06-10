package LeetcodePrimaryAlgorithm.str;

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */
public class Demo05 {
    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(arr[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[right])) {
                right--;
                continue;
            }
            if (Character.toUpperCase(arr[left]) != Character.toUpperCase(arr[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome("race a car");
    }
}
