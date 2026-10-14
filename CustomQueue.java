// Common interface for queue (FIFO)
public interface CustomQueue<T> {
    // methods for: add, remove, search, is empty, size
    void enqueue(T newItem);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}