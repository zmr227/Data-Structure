package Basic;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    // O(1)
    public int getCapacity() { return array.getCapacity(); }

    // O(1)
    @Override
    public int getSize() {
        return array.getSize();
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // O(1) 均摊
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // O(n)
    @Override
    public E dequeue() { return array.removeFirst(); }

    // O(1)
    @Override
    public E getFront() { return array.getFirst(); }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 1){  // i = 1 || i = 4
                queue.dequeue();
                System.out.println("pop "+ queue);
            }
        }
    }
}
