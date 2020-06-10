package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true


提示：

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='
 */
public class Demo990 {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    /*
    public boolean equationsPossible(String[] equations) {
        Set<Set<Character>> equals = new HashSet<>();
        Map<Character, Set<Character>> Notequals = new HashMap<>();
        for (String equation : equations) {
            char left = equation.charAt(0), right = equation.charAt(3);
            if (equation.substring(1, 3).equals("==")) {
                if (left == right) continue;
                //判否条件
                if (Notequals.containsKey(left) && Notequals.get(left).contains(right)
                        || Notequals.containsKey(right) && Notequals.get(right).contains(left))
                    return false;

                //可添加
                boolean flag = false;
                for (Set<Character> cSet : equals) {
                    if (cSet.contains(left) || cSet.contains(right)) {
                        cSet.add(right);
                        cSet.add(left);
                        flag = true;
                        break;
                    }
                }
                //之前set没有相同元素
                if (!flag) {
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(right);
                    newSet.add(left);
                    equals.add(newSet);
                }

            } else {
                if (right == left) return false;
                //判否条件
                for (Set<Character> e : equals)
                    if (e.contains(right) && e.contains(left)) return false;

                //可添加
                if (Notequals.containsKey(left)) Notequals.get(left).add(right);
                else {
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(right);
                    Notequals.put(left, newSet);
                }
                if (Notequals.containsKey(right)) Notequals.get(right).add(left);
                else {
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(left);
                    Notequals.put(right, newSet);
                }
            }
        }
        return true;
    }

     */

}
