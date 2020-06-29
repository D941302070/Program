package LeetcodePrimaryAlgorithm.list;

/*
 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class Demo03 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = null, second = head;
        while (second.next != null) {
            ListNode tem = second.next;
            second.next = first;
            first = second;
            second = tem;
        }
        second.next = first;
        return second;
    }
}
