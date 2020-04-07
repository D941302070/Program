package Leetcode;

public class Demo83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tem = new ListNode(0);
        tem.next = head;
        ListNode now = head,before = tem;
        while (true) {
            if(now == null || now.next == null) break;
            if(now.next.val == now.val){
                before.next = now.next;
                now = before;
            }
            now = now.next;
            before = now;
        }
        return tem.next;
    }
    public void delete(ListNode head,ListNode before){
        if(head == null || head.next == null) return;
        if(head.next.val == head.val){
            before.next = head.next;
            head = before;
        }
        delete(head.next,head);
    }
}
