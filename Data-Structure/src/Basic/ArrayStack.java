package Basic;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    // O(1)
    public int getCapacity() {
        return array.getCapacity();
    }

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

    // O(1)
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // O(1)
    @Override
    public E pop() {
        return array.removeLast();
    }

    // O(1)
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top"); // top of stack
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
