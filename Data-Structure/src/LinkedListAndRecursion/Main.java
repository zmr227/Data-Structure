package LinkedListAndRecursion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 3, 6, 4, 7, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution_203()).removeElements4(head, 6, 0);
        System.out.println(res);
    }
}
