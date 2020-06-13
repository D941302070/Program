package LeetcodePrimaryAlgorithm.others;

import java.util.Stack;

/*
有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class Demo05 {
    public boolean isValid(String s) {
        if (s == null) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (c == '[')
                stack.push(c);
            else if (c == '{')
                stack.push(c);
            else if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(')
                    || (c == ']' && stack.peek() == '[')
                    || (c == '}' && stack.peek() == '{'))) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }
}
