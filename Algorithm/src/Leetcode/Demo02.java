package Leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 */
public class Demo02 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newListHead = new ListNode(0);
        ListNode p = l1, q = l2, newList = newListHead;
        int plus = 0;//进位
        while (p != null || q != null) {
            int x, y;
            if (p == null) x = 0;
            else x = p.val;
            if (q == null) y = 0;
            else y = q.val;

            int num = x + y + plus;
            plus = num / 10;//储存下位的数字
            newList.next = new ListNode(num % 10);
            newList = newList.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (plus > 0)
            newList.next = new ListNode(plus);
        return newListHead.next;
    }
}
