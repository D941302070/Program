package Leetcode;

import java.util.*;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class Demo20 {

    Map<Character, Character> map = new HashMap<>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char temp : s.toCharArray()) {
            //找到左括号，压入右括号
            /*
            if (map.containsKey(temp)) stack.push(map.get(temp));
            元素少用if，用map费时间
             */
            if(temp=='(')
                stack.push(')');
            else if(temp=='{')
                stack.push('}');
            else if(temp=='[')
                stack.push(']');
            //其余判断不匹配情况，1.栈空，2,出栈元素不是当前元素
            else if (stack.isEmpty() || temp != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
