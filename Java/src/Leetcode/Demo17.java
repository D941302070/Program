package Leetcode;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

img[https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png]

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo17 {
    List<String> list = new ArrayList<>();
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return list;
        findString("", digits);
        return list;
    }

    public void findString(String nowStr, String numbers) {
        //扫描的字符串为空，添加字符串
        if (numbers.length() == 0)
            list.add(nowStr);
        else {
            //获取当前要扫描的数字的对应字符
            String scannerCharStr = map.get(numbers.substring(0, 1));
            for (int i = 0; i < scannerCharStr.length(); i++) {
                String newStr = nowStr + scannerCharStr.substring(i, i + 1);
                findString(newStr, numbers.substring(1));
            }
        }
    }
    /*
    public void backtrack(String combination, String next_digits) {
        if(next_digits.length()==0) {
            list.add(combination);
        }else{
            String letter = next_digits.substring(0,1);
            for(int i=0 ;i<map.get(letter).length();i++) {
                backtrack(combination+map.get(letter).substring(i,i+1),next_digits.substring(1));
            }
        }

    }*/
}
