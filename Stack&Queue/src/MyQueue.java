public class MyQueue<T> implements Queue<T> {

    MyArray<T> data;

    public MyQueue(int capacity){
        data = new MyArray<>(capacity);
    }
    public MyQueue(){
        data = new MyArray<>();
    }

    // FIFO, 均摊O(1)
    @Override
    public void enqueue(T elem){
        data.addLast(elem);
    }

    // O(n) 使用array实现，每次将首个元素取出后，之后的元素需要全部前移一位，消耗极大。
    @Override
    public T dequeue(){
        return data.removeFirst();
    }

    // O(1)
    @Override
    public T getFirst(){
        return data.getFirst();
    }

    // O(1)
    @Override
    public int getSize(){
        return data.getSize();
    }

    // O(1)
    public int getCapacity(){
        return data.getCapacity();
    }

    // O(1)
    @Override
    public boolean isEmpty(){
        return data.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for(int i = 0; i < data.getSize(); i++){
            res.append(data.get(i));
            if(i != data.getSize() - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
