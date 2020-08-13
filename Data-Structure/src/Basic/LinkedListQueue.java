package Basic;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    // 从head端删除元素，从tail端添加元素
    // 没有dummyHead，需要特别小心链表为空的情况
    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // O(1)
    @Override
    public int getSize() {
        return size;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    // O(1)
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed: empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null; // remove reference for GC
        if (head == null) {
            tail = null;
        }
        size --;
        return delNode.e;
    }

    // O(1)
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: [head] ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL [tail]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> q = new LinkedListQueue<>();
        for (int i = 0; i < 8; i ++) {
            q.enqueue(i);
            System.out.println(q);
            if (i % 3 == 2) {
                q.dequeue();
                System.out.println(q);
            }
        }
    }
}
