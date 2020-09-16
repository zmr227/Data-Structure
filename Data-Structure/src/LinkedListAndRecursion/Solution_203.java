package LinkedListAndRecursion;

// Remove all elements from a linked list of integers that have value val.

// with dummy head
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

    // without dummy head
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

    // recursive
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
//        if (head.val == val) {
//            return head.next;
//        }
//        return head;
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements4(ListNode head, int val, int depth) {
        if (head == null) {
            return null;
        }
        String depthString = generateDepthString(depth);
        System.out.println(depthString + "Call: remove " + val + " in " + head);

        ListNode nextNode = removeElements4(head.next, val, depth + 1);
        System.out.println(depthString + "After remove " + val + ": " + nextNode);

        ListNode retNode;
        if (head.val == val) {
            retNode = nextNode;
        } else {
            head.next = nextNode;
            retNode = head;
        }
        System.out.println(depthString + "Return: " + retNode);
        return retNode;
    }

    // the longer "----" it prints, the deeper recursion call current func is in
    public String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++) {
            res.append("--");
        }
        return res.toString();
    }
}
