package LeetcodePrimaryAlgorithm.list;

public class Demo01 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
