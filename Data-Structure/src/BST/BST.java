package BST;

import java.util.*;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E val;
        public Node left, right;

        public Node(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    public int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // add node
    public void add(E e) {
        root = add(root, e);
    }

    // add node to a particular subtree
    // return the root of new tree
    private Node add(Node root, E e) {
        if (root == null) {
            size ++;
            return new Node(e);
        }

        // if e.equals(root.val): do nothing
        if (e.compareTo(root.val) < 0) { // e < root.val
            root.left = add(root.left, e);
        } else if (e.compareTo(root.val) > 0) {
            root.right = add(root.right, e);
        }
        return root;

//        // already exists
//        if (e.equals(root.val)) {
//            return;
//        }
//        } else if (e.compareTo(root.val) < 0 && root.left == null) {
//            root.left = new Node(e);
//            size ++;
//            return;
//        } else if (e.compareTo(root.val) < 0 && root.right == null) {
//            root.right = new Node(e);
//            size ++;
//            return;
//        }
    }

    // if BST contains value e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }
        if (e.equals(root.val)) {
            return true;
        } else if (e.compareTo(root.val) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    // preorder traverse
    public void preOrder() {
        preOrder(root);
    }

    // 1) Recursive
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2) Non-recursive
    public void preOrderNR() {
        preOrderNR(root);
    }
    private void preOrderNR(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    // inorder traverse == sort
    // 1) Recursive
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    // 2) Non Recursive
    public void inOrderNR() {
        inOrderNR(root);
    }
    private void inOrderNR(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;

        while (!(stack.isEmpty() && cur == null)) {
            if (cur != null) {
                // 当前节点先入栈, 后访问
                stack.addFirst(cur);
                // 先处理左孩子
                cur = cur.left;
            } else {
                // 由于左孩子为空才会走到这个else branch
                // 可以访问这个左孩子的parent, 即当前栈顶元素
                // 访问节点, 执行业务逻辑
                Node node = stack.removeFirst();
                System.out.println(node.val);

                // 再处理右孩子
                cur = node.right;
            }
        }
    }

    // postorder traverse
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    public void postOrderNR() {
        postOrderNR(root);
    }

    private void postOrderNR(Node root) {
        if (root == null)
            return;
        Deque<Node> stack = new LinkedList<>();
        Node cur = root;

        while (!(stack.isEmpty() && cur == null)) {
            // push all left child if exists
            if (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            } else { // check right child
                Node node = stack.getFirst();
                // 该节点没有左孩子和右孩子, 可以访问
                if (node.right == null) {
                    node = stack.removeFirst();
                    System.out.println(node.val);

                    if (stack.isEmpty())
                        break;

                    // 如果该节点是其父亲(当前栈顶元素)的左孩子
                    Node curParent = stack.peek();
                    if (node.equals(curParent.left))
                        // 先继续处理右孩子
                        cur = curParent.right;
                    else {
                        // 如果是当前栈顶元素的右孩子
                        // 说明父亲节点的左右孩子都已经访问过, 可以访问父亲节点
                        // 处理链表型右孩子的情况
                        while (!stack.isEmpty() && node.equals(curParent.right)) {
                            node = stack.removeFirst();
                            System.out.println(node.val);
                            curParent = stack.peek();
                        }
                    }
                } else
                    // 该节点有右孩子, 先处理右孩子
                    cur = node.right;
            }
        }
    }

    // level order traverse
    public List<List<E>> levelOrderTraverse() {
        return levelOrderTraverse(root);
    }

    private List<List<E>> levelOrderTraverse(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<E>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int stackSize = queue.size();
            List<E> level = new ArrayList<>();

            for (int i = 0; i < stackSize; i ++) {
                Node cur = queue.remove();
                level.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public E getMin() {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return getMinNode(root).val;
//        Node cur = root;
//        while (cur.left != null) {
//            cur = cur.left;
//        }
//        return cur.val;
    }

    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    public E getMax() {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.val;
    }

    public E removeMin() {
        E minVal = getMin();
        root = removeMinNode(root);
        return minVal;
    }

    // return the root of new tree after removal
    private Node removeMinNode(Node root) {
        if (root.left == null) {
            Node rightChild = root.right;
            root.right = null;
            size --;
            return rightChild;
        }
        root.left = removeMinNode(root.left);
        return root;
    }

    public E removeMinNR() {
        if (root == null) {
            throw new IllegalArgumentException("tree is empty。");
        }
        //待删除节点的父亲节点
        Node parent = null;
        Node cur = root;
        while (cur.left != null) {
            parent = cur;
            cur = cur.left;
        }
        // 说明要删除root
        if (parent == null) {
            E min = root.val;
            root = cur.right;
            cur.right = null;
            size --;
            return min;
        }
        parent.left = cur.right;
        cur.right = null;
        size --;
        return cur.val;
    }

    public E removeMax() {
        E maxVal = getMax();
        root = removeMaxNode(root);
        return maxVal;
    }

    private Node removeMaxNode(Node root) {
        if (root.right == null) {
            Node leftChild = root.left;
            root.left = null;
            size --;
            return leftChild;
        }
        root.right = removeMaxNode(root.right);
        return root;
    }

    public void remove(E val) {
        root = remove(root, val);
    }

    private Node remove(Node root, E val) {
        // did not find the node
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            // only have left/right child
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size --;
                return rightNode;
            }
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size --;
                return leftNode;
            }
            // use the min of right subtree/max of left subtree as new root
            Node successor = getMinNode(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
        else if (val.compareTo(root.val) < 0) {
            root.left = remove(root.left, val);
        }
        else {
            root.right = remove(root.right, val);
        }
        return root;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, res, 0);
        return res.toString();
    }

    private void generateBSTString(Node node, StringBuilder res, int depth) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null \n");
            return;
        }
        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, res, depth + 1);
        generateBSTString(node.right, res, depth + 1);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i ++) {
            res.append("-");
        }
        return res.toString();
    }
}

