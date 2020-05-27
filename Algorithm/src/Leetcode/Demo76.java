package Leetcode;

import java.util.HashMap;

import java.util.Map;
/*
未完成

 */
public class Demo76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int start = 0, end = 0, count = 0;
        boolean flag = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), 1);
        for (int i = 0; i < s.length(); i++)
            if (map.containsKey(s.charAt(i)))
                if (!flag) {
                    flag = true;
                    count++;
                } else if (flag && count < t.length() - 1)
                    count++;
                else if (count == t.length() - 1)
                    return s.substring(start, end + 1);
        return "";
    }
}
