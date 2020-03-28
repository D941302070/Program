package Leetcode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class Demo19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode nowNode = new ListNode(0), flagNode = nowNode ,beforeFlag = flagNode;
        //是一个空的头结点
        nowNode.next = head;
        for (int i = 0; i < n; i++) {
            if (i!=0)
                beforeFlag = beforeFlag.next;
            flagNode = flagNode.next;
        }
        if (flagNode.next ==null)
            return head.next;
        while (flagNode.next != null) {
            nowNode = nowNode.next;
            flagNode = flagNode.next;
        }

        nowNode.next = nowNode.next.next;
        return head;
    }
}
