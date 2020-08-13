package Basic;

public class LinkedList<E> {
    private class Node<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }

    // O(n/2) = O(n) on avg
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, illegal index");
        }
        // 找到index位置的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 链表头添加元素, O(1)
    public void addFirst(E e) {
    //     1. Node newHead = new Node(e);
    //        newHead.next = head;
    //        head = newHead;
    //     2. head = new Node(e, head);
    //     size ++;
        add(0, e);
    }

    // 链表末尾添加元素, O(n), 需要遍历整个list
    public void addLast(E e) {
        add(size, e);
    }

    // O(n/2) = O(n)
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, illegal index");
        }
        Node node = dummyHead;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return (E) node.e;
    }

    // O(1)
    public E getFirst() {
        return get(0);
    }

    // O(n)
    public E getLast() {
        return get(size - 1);
    }

    // O(n/2) = O(n)
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, illegal index");
        }
        Node node = dummyHead;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    // O(n/2) = O(n)
    public boolean contains(E e) {
        Node node = dummyHead;
        while (node != null) {
            if (node.e.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // O(n/2) = O(n)
    // get the prev node
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null; // remove reference，ready for GC
        size --;

        return (E) delNode.e;
    }

    // O(1)
    public E removeFirst() {
        return remove(0);
    }

    // O(n)
    public E removeLast() {
        return remove(size - 1);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        res.append("Linked List: ");
//        Node node = dummyHead.next;
//        while (node != null) {
        for (Node node = dummyHead.next; node != null; node = node.next){
            res.append(node.e + "->");
            // node = node.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5; i ++) {
            list.addLast(i);
            System.out.println(list);
        }
        list.add(3, 678);
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
}
