package com.datastructure.implementation;

/**
 * Implementation for Stack Data Structure.
 *
 * @author Rushikesh Paradkar
 */
public class Stack {

    /**
     * The Node representing inside a Stack data structure.
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

    private Node top;

    /**
     * Default Constructor for creating a {@link Stack}.
     */
    Stack() {
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Gives the top element of the stack.
     * <p/> Note: This operation does not removes the element from the stack.
     * It just returns the top element's data value without removing it from
     * the data structure.
     *
     * @return The data value of the top element.
     * @throws EmptyStackException might throw an exception if the stack is empty.
     */
    public int peek() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    /**
     * Inserts a new node at the top of the stack and updates the top pointer of the stack.
     *
     * @param data The data value that needs to be inserted into the stack.
     */
    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    /**
     * Removes the top element from the stack.
     *
     * @return The data value that is removed from the stack.
     * @throws EmptyStackException might throw an exception if the stack is empty.
     */
    public int pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    /**
     * Helper method that displays the elements of the stack.
     *
     * @throws EmptyStackException might throw an exception if the stack is empty.
     */
    public void displayStack() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        Node head = top;
        while (head.next != null) {
            System.out.print(head.data + " || ");
            head = head.next;
        }
    }

    /**
     * The Exception that is thrown when trying to perform an unsupported operation.
     *
     * @author Rushikesh Paradkar
     */
    class EmptyStackException extends Exception {

        /**
         * {@inheritDoc}.
         */
        @Override
        public String toString() {
            return "The Stack is Empty. Cannot perform the expected operation.";
        }
    }

    /**
     * Main method that performs all the pop operations.
     *
     * @param args The input to be taken from the user for the
     *             implementation and demo (Not required for this example).
     */
    public static void main(String args[]) {

        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        try {
            stack.displayStack();
        } catch (EmptyStackException e) {
            System.out.print("Trying to display an empty stack. Aborting...");
            e.printStackTrace();
        }

        try {
            int t = stack.pop();
            System.out.print(t + " removed from the stack.");
        } catch (EmptyStackException e) {
            System.out.print("Trying to remove from an empty stack. Aborting...");
            e.printStackTrace();
        }

        try {
            stack.displayStack();
        } catch (EmptyStackException e) {
            System.out.print("Trying to display an empty stack. Aborting...");
            e.printStackTrace();
        }
    }
}
