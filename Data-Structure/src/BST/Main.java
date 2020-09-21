package BST;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testRemoveNode();
    }

    public static void testTraversal() {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder(); // recursive
        System.out.println();
        bst.preOrderNR(); // non-recursive

        bst.inOrder(); // sorted nums
        System.out.println();
        bst.inOrderNR(); // non-recursive

        bst.postOrder();
        System.out.println();
        bst.postOrderNR();
        System.out.println(bst.levelOrderTraverse());
    }

    public static void testRemoveMinMaxNode() {
        BST<Integer> bst = new BST<Integer>();
        Random random = new Random();
        int n = 100;
        for (int i = 0; i < n; i ++) {
            bst.add(random.nextInt(1000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for(int i = 1; i < nums.size(); i ++) {
            if (nums.get(i-1) <= nums.get(i)) {
                throw new IllegalArgumentException("Error: removeMax() not working properly.");
            }
        }
        System.out.println("removeMax() test completed");
    }

    public static void testRemoveNode() {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        System.out.println(bst);
        bst.remove(3);
        System.out.println("After remove: \n" + bst);
    }

    public void testBSTSet() {

    }
}
