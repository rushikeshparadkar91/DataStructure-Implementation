/**
 * Implementation of a Linked List.
 *
 * @author Rushikesh Paradkar.
 */
public class LinkedList {

    /**
     * Class to represent a Node in a {@link LinkedList}.
     */
    class Node {
        private int data;
        private Node next;

        /**
         * Default Constructor for a Node of a Linked List.
         */
        Node() {
        }
    }

    /**
     * Inserts a Node at the head of the Linked List.
     *
     * @param head The head of the Linked List.
     * @param x    The data value that needs to be added for the new Node.
     * @return The head Node of the Linked List.
     */
    public Node Insert(Node head, int x) {
        Node root = head;
        if (root == null) {
            Node newNode = new Node();
            newNode.data = x;
            newNode.next = null;
            head = newNode;
            return head;
        } else {
            Node newNode = new Node();
            newNode.data = x;
            newNode.next = root;
            head = newNode;
            return head;
        }
    }

    /**
     * Delete a Node at a specified position in a Linked List.
     *
     * @param head     The head of the Linked List.
     * @param position The position at which the node deletion must take place.
     * @return The head Node of the Linked List.
     */
    public Node Delete(Node head, int position) {
        Node root = head;
        if (root == null) {
            return null;
        }
        if (position == 0) {
            head = head.next;
            return head;
        }
        int k = 0;
        while (root.next != null && k < position - 1) {
            root = root.next;
            k++;
        }
        Node next = root.next;
        root.next = next.next;
        return head;
    }

    /**
     * Inserts a Node at a specified position.
     *
     * @param head     The head of the Linked List.
     * @param data     The data value that needs to be added for the new Node.
     * @param position The position at which the Node is to be added.
     * @return The head Node of the Linked List.
     */
    public Node InsertNth(Node head, int data, int position) {

        // Creating a reference pointer for head of the list so that head remians intact as it needs to be returned
        // by the function.
        Node root = head;
        Node newNode = new Node();
        newNode.data = data;

        // Condition if the head itself is null - List is empty.
        if (root == null) {
            return newNode;
        }

        // Condition where position to enter is the first node of the linked list.
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        // Condition where node needs to be inserted at a specific position (Could be at the end as well).
        int currentPosition = 0;
        while (currentPosition < position - 1 && root.next != null) {
            root = root.next;
            currentPosition++;
        }

        newNode.next = root.next;
        root.next = newNode;
        return head;
    }

    /**
     * Prints the elements of the Linked List.
     *
     * @param head The head of the Linked List.
     */
    public void Print(Node head) {
        if (head == null) return;
        Node node = head;
        while (true) {
            System.out.println(node.data + " ");
            if (node.next != null) {
                node = node.next;
            } else {
                break;
            }

        }
    }

    /**
     * Reverse the provided Linked List.
     *
     * @param head The head of the Linked List.
     * @return The head Node of the reversed Linked List.
     */
    public Node Reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * Prints the elements in the Linked List in a reverse order.
     *
     * @param head The head of the Linked List.
     */
    public void ReversePrint(Node head) {
        if (head == null) {
            return;
        }
        ReversePrint(head.next);
        System.out.println(head.data);
    }
}
