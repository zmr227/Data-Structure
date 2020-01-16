public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    private int front, tail, size;

    public LoopQueue(int capacity){
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1; // 有意识的浪费了一个位置来区分数组的空/满。
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
//        int cur_front = front % data.length;
//        int cur_tail = tail % data.length;
//        if(cur_front <= cur_tail){
//            return cur_tail - cur_front;
//        }
//        else {
//            return cur_tail + data.length - cur_front;
//        }
                //     f
                // 5,_,0,1,2,3,4
                // t              // t - f || (t + c - f)
    }

    @Override
    public void enqueue(T elem){
        // queue is full
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = elem;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public T dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Dequeue failed, empty queue");
        }

        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (size < data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    @Override
    public T getFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty.");
        }
        return data[front];
    }

    public void resize(int new_capacity){
        T[] new_data = (T[]) new Object[new_capacity + 1];
        for(int i = 0; i < size; i++){
            new_data[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = new_data;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue size = %d, capacity = %d\n", size, data.length));
        res.append("Front [");
        for(int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
