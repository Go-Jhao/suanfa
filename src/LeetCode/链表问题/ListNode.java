package LeetCode.链表问题;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void setNext (ListNode newNode) {
        if (this.next == null) { // 如果只有一个节点
            this.next = newNode; // 保存新节点
        } else { // 当前节点后面还有节点
            // 当前节点的下一个节点继续保存
            this.next.setNext(newNode);
        }
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        if (this == null)
            return "null";
        return "ListNode{" +
                "val=" + val+"}";
    }

}
