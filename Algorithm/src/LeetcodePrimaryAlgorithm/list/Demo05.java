package LeetcodePrimaryAlgorithm.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
 */
public class Demo05 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        for (int i = 0; i < len / 2; i++)
            if (list.get(i).compareTo(list.get(len - 1 - i)) != 0) return false;

        return true;
    }
}
