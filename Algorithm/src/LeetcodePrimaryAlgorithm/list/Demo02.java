package LeetcodePrimaryAlgorithm.list;

/*
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。
 */
public class Demo02 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //过n-1个节点
        ListNode none = new ListNode(0), fast = none, low = none;
        none.next = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        //快慢指针同时走
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        //删除节点
        low.next = low.next.next;
        return none.next;
    }
}
