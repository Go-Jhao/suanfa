package LeetCode.链表问题;

public class LeetCode_83删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==null||head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
