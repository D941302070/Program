package Leetcode;

public class Demo206 {
    //双指针
    /*
    //参考
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, now = head ,tem;
        while (now != null) {
            tem = now.next;
            now.next = pre;
            pre = now;
            now = tem;
        }
        return pre;
    }
     */
    ListNode newFirst;
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        reverse(head);
        head.next = null;
        return newFirst;
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            newFirst = head;
            return head;
        }
        reverse(head.next).next = head;
        return head;
    }
}
