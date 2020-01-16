public class MyStack<T> implements Stack<T> {
    MyArray<T> data;

    public MyStack(int capacity){
        data = new MyArray<>(capacity);
    }

    public MyStack(){
        data = new MyArray<>();
    }

    // O(1), 均摊，可能触发resize
    @Override
    public void push(T elem){
        data.addLast(elem);
    }

    // O(1), 均摊，可能触发resize
    @Override
    public T pop(){
        return data.removeLast();
    }

    // O(1)
    @Override
    public T peek(){
        return data.getLast();
    }

    // O(1)
    @Override
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // O(1)
    @Override
    public int getSize(){
        return data.getSize();
    }

    // user can only see the top elem of a stack
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i = 0; i < data.getSize(); i++){
            res.append(data.get(i));
            if(i != data.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

    // only exists when implement it with array
    public int getCapacity(){
        return data.getCapacity();
    }
}
