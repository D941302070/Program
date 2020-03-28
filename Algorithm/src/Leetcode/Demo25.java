package Leetcode;

import java.util.Stack;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :
给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Demo25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        //判空
        if (head == null || k == 0) return head;
        Stack<ListNode> stack = new Stack<>();
        //空头节点
        ListNode nullHead = new ListNode(0);
        nullHead.next = head;
        //一个找位置，两个记7个点的头尾
        ListNode nowNode = head, smallHead = nullHead, smallTile = null;
        while (true) {
            //压栈
            for (int i = 0; i < k; i++) {
                if (nowNode == null) {
                    //不足k弹栈
                    ListNode p, q = null;
                    while (!stack.isEmpty()) {
                        p = stack.pop();
                        p.next = q;
                        q = p;
                    }
                    return nullHead.next;
                }
                stack.push(nowNode);
                nowNode = nowNode.next;
            }
            //找到尾点,可能为空指针,万一空指针，下次循环就会跳出
            smallTile = nowNode;
            //接受弹栈的点
            nowNode = smallHead;
            //弹出
            for (int i = 0; i < k; i++) {
                nowNode.next = stack.pop();
                nowNode = nowNode.next;
            }
            //接尾
            nowNode.next = smallTile;
            //重新找下次的头
            smallHead = nowNode;
            nowNode = nowNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        reverseKGroup(p1, 3);
    }
}
