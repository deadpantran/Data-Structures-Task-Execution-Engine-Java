// Step 3: Implementation B - Array-Based (Resizing / Circular)
@SuppressWarnings("unchecked") // Silences java compiler warnings when casting a raw Object[]
// to a generic T[].
public class ArrayStack<T> implements CustomStack<T>{
    // The Array
    private T[] storage;

    // Data Field: top pointer (array has its own size method)
    private int top;

    // Constructor: we specify the fixed size of the array.
    // By definition in the Java Language Specification (JLS),
    // a constructor's name must exactly match the simple name of the unadorned class (ArrayStack).
    public ArrayStack(int initialCapacity){
        this.storage = (T[]) new Object[initialCapacity]; // A Generic Type Array
        this.top = -1; // when we add an item, we increment top pointer
        // and it functions as an index pointer
    }

    // Override abstract methods
    @Override
    public void push(T newItem){
        if (top == storage.length - 1){ // full capacity?
            resize(storage.length * 2); // increase the capacity of the array before adding
        }
        storage[++top] = newItem; // increment first, then set top pointer to new item [++X]
    }

    @Override
    public T pop(){
        T data = storage[top];
        storage[top--] = null; // set top pointer to null first, then decrement [X++]
        if (top > 0 && top == storage.length / 4){ // extra space in the array?
            resize(storage.length / 2); // decrease the capacity of the array after removing
        }
        return data;
    }

    @Override
    public T peek(){
        return storage[top];
    }

    @Override
    public boolean isEmpty(){
        return top == -1;
    }

    @Override
    public int size(){
        return top + 1;
    }

    // custom method for resizing the array
    private void resize(int newCapacity){
        T[] temp = (T[]) new Object[newCapacity]; // create a new generic type array
        // System.arraycopy(Object source_array, int starting_index_source_array,
        // Object target_array, int starting_index_target_array, int total_elements_to_copy)
        // is a built-in Java method used to copy a sequence
        // of elements from one array into another. 
        System.arraycopy(storage, 0, temp, 0, top + 1);
        storage = temp; // replace our array with the new one
    }
}