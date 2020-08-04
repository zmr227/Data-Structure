public class Array<T> {
    private T[] data;
    private int size; // point to the next position

    // constructor with/without param (capacity)
    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        data = (T[]) new Object[10];
        size = 0;
    }

    // getters
    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    // check empty
    public boolean isEmpty(){
        return size == 0;
    }

    // reuse the insert function

    // add elem to the head, O(n)
    public void addFirst(T elem){
        insert(0, elem);
    }

    // add elem to the tail，O(1)
    public void addLast(T elem){
        insert(size, elem);
    }

    // add elem to specific position，on average O(n/2) = O(n)
    public void insert(int idx, T elem){
        if(size == data.length){
            // option 1: throw an exception
            // throw new IllegalArgumentException("Add failed, array is full");
            // option 2: expand the array, add more capacity
            resize(2 * data.length);
        }
        // if idx > size, there'll be empty slot(s) in the array
        if(idx < 0 || idx > size) {
            throw new IllegalArgumentException("Invalid index");
        }

        for (int i = size; i > idx; i--){
            data[i] = data[i-1];
        }
        data[idx] = elem;
        size++;
    }

    // Encapsulation, prevent user from accessing empty slot/whole data array
    // get/set elem by index，O(1)
    public T get(int idx){
        if(idx < 0 || idx >= size){
            throw new IllegalArgumentException("Get failed, invalid index");
        }
        return data[idx];
    }
    // O(1)
    public void set(int idx, T elem){
        if(idx < 0 || idx >= size){
            throw new IllegalArgumentException("Get failed, invalid index");
        }
        data[idx] = elem;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }
    // check if arr contains particular element, O(n)
    public boolean contains(T elem){
        for(int i = 0; i < size; i++){
            if(data[i].equals(elem)){
                return true;
            }
        }
        return false;
    }

    // find the idx of an element, O(n)
    public int find(T elem){
        for(int i = 0; i < size; i++){
            if(data[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }

    // remove element from head / tail / by index，O(n)
    public T removeFirst(){
        return remove(0);
    }

    // O(1)
    public T removeLast(){
        return remove(size - 1);
    }

    // O(n)
    public void removeElement(T elem){
        int idx = find(elem);
        if(idx != -1) {
            remove(idx);
        }
    }

    // on average O(n/2) = O(n)
    public T remove(int idx){
        if(idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Remove failed, invalid index");
        }

        T ret = data[idx];
        for(int i = idx; i < size - 1; i++){
            data[i] = data[i+1];
        }
        size --;
        data[size] = null;  // loitering objects != memory leak

        // Lazy, shrink the array when reaches n/4
        if(size <= data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2); // if data.length == 1, len / 2 will become 0
        }

        return ret;
    }

    // print the array
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    // dynamic length，O(n)
    public void resize(int new_capacity){
        T[] new_data = (T[])new Object[new_capacity];

        for(int i = 0; i < size; i++){
            new_data[i] = data[i];
        }
        data = new_data;
    }


}
