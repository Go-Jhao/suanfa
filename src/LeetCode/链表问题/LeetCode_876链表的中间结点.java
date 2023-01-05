package LeetCode.链表问题;

public class LeetCode_876链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head , slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
