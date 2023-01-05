package LeetCode.链表问题;

public class LeetCode_142环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slowPtr = head , fastPtr = head;
        boolean loopExists = false;
        while (fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr){
                loopExists = true;
                break;
            }
        }
        if (loopExists){//环存在
            slowPtr = head;
            while (slowPtr != fastPtr){
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
            return slowPtr;//返回开始的节点
        }
        return null;//环不存在
    }
}
