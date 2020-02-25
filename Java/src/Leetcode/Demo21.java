package Leetcode;

/*
21. 合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Demo21 {
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
