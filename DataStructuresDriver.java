// Step 4: Main Execution
public class DataStructuresDriver{
    public static void main(String[] args){
        System.out.println("=== Testing Linear Data Structures Engine ===");

        // 1. Linked-List Queue Test
        // Create the Linked-List Queue
        // Interface<data type> = new Implementation<>();
        // Now we declare the exact data type we want to use instead of using generic type <T>.
        // '<>' in the constructor call is a shorthand that tells the compiler
        // to use the type parameter already specified on the left side of the assignment.
        CustomQueue<String> taskQueue = new LinkedListQueue<>();
        taskQueue.enqueue("Task 1: Process Signal Data");
        taskQueue.enqueue("Task 2: Compile System Log");
        System.out.println("Processing Queue (FIFO): " + taskQueue.dequeue());

        // 2. Array Stack Test
        CustomStack<String> undoStack = new ArrayStack<>(2);
        undoStack.push("State A");
        undoStack.push("State B");
        undoStack.push("State C"); // Triggers dynamic resize
        System.out.println("Reverting State (LIFO): " + undoStack.pop());
    }
}