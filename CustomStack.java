// Task Dispatch & Processing Engine: models real-word
// task management using two different memory backing strategies:
// Array-Based Circular Queue / Stack: fixed memory allocation, array indexing, capacity resizing
// Linked-List Based Queue / Stack: dynamic memory allocation, node-pointer manipulation, unbounded capacity

// Step 1: Core Architecture and Interface
// Create an interface that both implementations will fulfill.
// Common interface for stack (LIFO)
public interface CustomStack<T> {
    // methods for: add, remove, search, is empty, size
    void push(T newItem);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

// A file can only contain one public top-level class or interface
// and the filename must match that public name exactly.
