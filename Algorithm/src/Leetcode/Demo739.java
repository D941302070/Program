package Leetcode;

import java.util.Stack;

/*
739. 每日温度
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Demo739 {
    public int[] dailyTemperatures1(int[] T) {
        //自己写的
        /*
        通过栈来实现
        一次比较栈顶和和当前栈，
        要是栈顶小，栈顶的元素结果就是当前的元素
        要是当前元素大，那么将当前元素压入栈中

        如果结束栈中还有元素不需要管，这些都没有跟大元素在右边的
        一直都是0
         */
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int tem = stack.pop();
                res[tem] = i - tem;
            }
            stack.push(i);
        }
        return res;
    }
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        //逆序扫描外层
        for (int i = T.length - 2; i >= 0; i--) {
            /*
            正序扫描内层，找到最近比他大的元素
            如果j右边没有比j'大的元素，i还比j大，那么i肯定右边没有比i大的元素
            每次跳跃值为j元素中储存的最近比j大的元素
            如果碰到j元素所储存为0，那么i直接跳过
            */
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
