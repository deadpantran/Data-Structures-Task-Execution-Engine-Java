// Step 2: Implementation A - Node-Based (Linked List)
// Linked-List Implementation of Queue (FIFO)
// Uses Generic Data Type <T> so that it can be used with any data type.
public class LinkedListQueue<T> implements CustomQueue<T>{
    // Linked List Node
    // private (encapsulation) and static (memory optimization)
    private static class Node<T>{
        // Data Fields: date and next pointer
        T data;
        Node<T> next;

        // Constructor
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    // Data Fields: head/tail pointer and size
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    // a constructor's name must exactly match the simple name of the unadorned class (LinkedListQueue).
    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Override the abstract methods
    @Override
    public void enqueue(T newItem){
        Node<T> newNode = new Node<>(newItem); // Create the node and add the specified data
        if (isEmpty()){
            head = newNode; // First item is both head and tail
            tail = newNode;
        } else {
            tail.next = newNode; // Link old tail to new node
            tail = newNode; // Move tail pointer forward
        }
        size++;
    }

    @Override
    public T dequeue(){
        if (isEmpty()) {
            // IllegalStateException is a built-in class. Because it inherits from
            // RuntimeException, you don't need to declare it in a method signature using
            // (method name) (throws) (IllegalStateException)
            throw new IllegalStateException("Queue Underflow"); // Nothing to remove
        }
        T data = head.data; // Hold node data
        head = head.next; // Move head pointer forward (deleting node)
        if (head == null){ // Removed last node
            tail = null;
        }
        size--;
        return data;
    }

    @Override
    public T peek(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty"); //Nothing to return
        }
        return head.data;
    }

    @Override
    public boolean isEmpty(){
        return head == null; // head != null as long as one node exists
    }

    @Override
    public int size(){
        return size; // counted manually
    }
}