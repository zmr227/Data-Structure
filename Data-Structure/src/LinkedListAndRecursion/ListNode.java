package LinkedListAndRecursion;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] vals) {
        if (vals == null || vals.length == 0) {
            throw new IllegalArgumentException("Illegal Array, cannot be empty");
        }
        this.val = vals[0];
        ListNode cur = this;
        for (int i = 1; i < vals.length; i ++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
