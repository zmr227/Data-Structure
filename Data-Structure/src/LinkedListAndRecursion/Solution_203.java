package LinkedListAndRecursion;

// Remove all elements from a linked list of integers that have value val.
public class Solution_203 {
    public ListNode removeElements1(ListNode head, int val) {
        // to remove node, get to the prev node
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.val == val) {
                // remove
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next; // not returning head because head might be removed
    }

    public ListNode removeElements2(ListNode head, int val) {
        // remove from head side
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

}
