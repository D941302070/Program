package Leetcode;

import java.util.List;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

 */
public class Demo23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return mergeTwoLists(node1, node2);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode left, right = l1, q = l2, headEmptyNode = new ListNode(0);
        headEmptyNode.next = l1;
        left = headEmptyNode;
        while (left != null) {
            if (q == null) break;
            if (right == null) {
                left.next = q;
                break;
            }
            if (right.val >= q.val) {
                left.next = q;
                q = q.next;
                left.next.next = right;
                left = left.next;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        return headEmptyNode.next;
    }
}
