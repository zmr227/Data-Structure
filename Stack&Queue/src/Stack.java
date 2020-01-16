public interface Stack<T> {

    void push(T elem);
    T pop();
    T peek();
    boolean isEmpty();
    int getSize();
}
