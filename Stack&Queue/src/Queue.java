public interface Queue<T> {
    void enqueue(T elem);
    T dequeue();
    T getFirst();
    boolean isEmpty();
    int getSize();
}
