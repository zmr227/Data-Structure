package BST;

public class BSTSet<E extends Comparable<E>> {
    private BST<E> bst;
    private int size;

    public BSTSet() {
        bst = new BST<E>();
        size = 0;
    }

    public int getSize() {
        return bst.size;
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public void add(E val) {
        bst.add(val);
    }

    public void remove(E val) {
        bst.remove(val);
    }
    public boolean contains(E val) {
        return bst.contains(val);
    }
}
