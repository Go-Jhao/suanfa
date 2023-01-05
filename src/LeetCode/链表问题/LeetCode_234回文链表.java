package LeetCode.链表问题;


public class LeetCode_234回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //当链表的个数是奇数把正中的归到左边
        if(fast != null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;

        while (slow != null){
            if (fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
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
