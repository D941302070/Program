package Leetcode;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:
给定 1->2->3->4, 你应该返回 2->1->4->3
 */
public class Demo24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null||head.next == null) return head;
        //空的头结点
        ListNode nullHead = new ListNode(0);
        ListNode left = head, right = head.next ,before = nullHead;
        while (true) {
            ListNode temp = right.next;
            //交换位置
            before.next = right;
            right.next = left;
            left.next = temp;
            //新的left，right
            before = before.next.next;
            if (before.next == null) break;
            left = before.next;
            right = left.next;
        }
        return nullHead.next;
    }
}
