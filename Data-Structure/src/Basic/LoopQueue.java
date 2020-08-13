package Basic;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int head, tail;
    private int size;

    public LoopQueue(int capacity) {
        // 1 extra space to ensure head != tail when queue is full
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // O(1)
    public int getCapacity() {
        return data.length - 1;
    }

    // O(1)
    @Override
    public int getSize() {
        return size;
    }

    // O(1)
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    // O(1) avg
    @Override
    public void enqueue(E e) {
        // queue is full
        if ((tail + 1) % data.length == head) {
            resize(getCapacity() * 2);
            // throw new IllegalArgumentException("Add failed, queue is full");
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    // O(1) avg
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        E res = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        // shrink size, cannot be 0.
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    // O(1)
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the queue is empty");
        }
        return data[head];
    }

    // O(n)
    private void resize(int newCapacity) {
        E[] newData= (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Loop Queue: size=%d, capacity=%d \nfront [", size, getCapacity()));

        // first elem at head, last elem at tail - 1, add comma if current relative index + 1 != tail
        for (int i = 0; i < size ; i++) {
             res.append(data[(head + i) % data.length]);
             if ((head + i + 1) % data.length != tail) {
                 res.append(", ");
             }
        }
//        for (int i = head; i != tail; i = (i + 1) % data.length) {
//            res.append(data[i]);
//            if ((i + 1) % data.length != tail) {
//                res.append(", ");
//            }
//        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>(2);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println("-> dequeue " + queue);
            }
        }
    }
}
