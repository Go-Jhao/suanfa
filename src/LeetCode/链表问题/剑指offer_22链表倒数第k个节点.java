package LeetCode.链表问题;

public class 剑指offer_22链表倒数第k个节点 {
    public static ListNode kthNodeFromEnd(ListNode head , int kthNode){
        if (kthNode <= 0 || head == null){
            return null;
        }
        ListNode fast = head , slow = null;
        int curr = 0;
        while (fast != null){
            if (curr < kthNode){
                fast = fast.next;
                curr++;
                if (curr == kthNode){
                    slow = head;
                }
            }else {
                fast = fast.next;
                slow = slow.next;
                curr++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(6);
        test.setNext(new ListNode(0));
        test.setNext(new ListNode(11));
        test.setNext(new ListNode(8));
        test.setNext(new ListNode(9));
        test.setNext(new ListNode(5));
        test.setNext(new ListNode(4));
        test.setNext(new ListNode(1));
        System.out.println(kthNodeFromEnd(test,9));
    }
}
