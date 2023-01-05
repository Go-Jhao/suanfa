package LeetCode.链表问题;

public class LeetCode_206反转链表 {
    public static ListNode reverseList(ListNode head) {
        if ( head == null) return null;
        ListNode preNode = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = next;
        }
        return preNode;
    }
}
