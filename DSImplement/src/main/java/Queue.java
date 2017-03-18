
/**
 * Implementation for Queue.
 *
 * @author Rushikesh Paradkar
 */
public class Queue {

    /**
     * The Node representing inside a {@link Queue} data structure.
     *
     * @author Rushikesh Paradkar
     */
    class Node {

        private int data;
        private Node next;

        /**
         * Constructor for {@link Node}.
         *
         * @param data The data value that needs to be set for the Node.
         */
        Node(final int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    /**
     * Default Constructor for {@link Queue}.
     */
    Queue() {
        head = null;
        tail = null;
    }

    /**
     * Checks if the Queue is empty.
     *
     * @return True if the queue is empty, false otherwise.
     */
    public boolean isQueueEmpty() {
        return head == null;
    }

    /**
     * Adds the data value to the queue.
     * <p /> Note: Addition takes place only at the tail of the queue.
     *
     * @param data The data value that needs to be added to the queue.
     */
    public void addToQueue(final int data) {
        Node n = new Node(data);
        if (tail != null) {
            tail.next = n;
        }
        tail = n;
        if (head == null) {
            head = n;
        }
    }

    /**
     * Removed the data value from the head of the queue.
     * <p /> Note: Will return -1 if the Queue is empty.
     *
     * @return The data value from the head of the queue.
     */
    public int removeFromQueue() {
        if (head == null) {
            System.out.println("Cannot delete. Queue Empty.");
            return -1;
        }
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    /**
     * Helper method that displays the Queue.
     */
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue is Empty. Nothing to display.");
        }
        Node root = head;
        while (root != null) {
            System.out.print(root.data + " <-- ");
            root = root.next;
        }
        System.out.println();
    }

    /**
     * Main method for implementation execution.
     *
     * @param args The input to be taken from the user for the
     *             implementation and demo (Not required for this example).
     */
    public static void main(String args[]) {
        Queue queue = new Queue();
        queue.displayQueue();

        queue.addToQueue(4);
        queue.displayQueue();
        queue.addToQueue(6);
        queue.displayQueue();
        queue.addToQueue(8);
        queue.displayQueue();
        queue.addToQueue(3);
        queue.displayQueue();
        queue.addToQueue(2);
        queue.displayQueue();

        queue.removeFromQueue();
        queue.displayQueue();
        queue.removeFromQueue();
        queue.displayQueue();
        queue.removeFromQueue();
        queue.displayQueue();
        queue.removeFromQueue();
        queue.displayQueue();
        queue.removeFromQueue();
        queue.displayQueue();
    }
}
