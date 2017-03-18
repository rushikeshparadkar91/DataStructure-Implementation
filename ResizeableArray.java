package com.java.arrays;

import java.awt.*;

/**
 * Resizeable Arrays Implementation.
 *
 * @author Rushikesh Paradkar
 */
public class ResizeableArray {
    private int items[];
    private int size;

    /**
     * Constructor with array size defaulted to 8 integers.
     */
    ResizeableArray() {
        items = new int[8];
        size = 0;
    }

    /**
     * Constructor with array size defaulted to expected number of integers the array needs to hold.
     *
     * @param expectedNumberOfElements The expected number of integers the array needs to hold.
     */
    ResizeableArray(int expectedNumberOfElements) {
        items = new int[expectedNumberOfElements];
        size = 0;
    }

    /**
     * Returns the size of the array.
     *
     * @return integer size of the array.
     */
    public int getArraySize() {
        return size;
    }

    /**
     * Method to display the items in an array.
     */
    public void displayArray() {
        for (int j = 0; j <= items.length; j++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
        for (int j = 0; j <= items.length; j++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * Sets the item at the specified index.
     *
     * @param index The index at which the item needs to be set.
     * @param item  The item that needs to be set at the specified index.
     * @throws ArrayIndexOutOfBoundsException if the index specified is out of size bound.
     */
    public void set(int index, int item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        items[index] = item;
    }

    /**
     * Appends an element at the end of the array.
     *
     * @param item The item to be added at the end.
     */
    public void append(int item) {
        checkIfArrayFullInSize();
        items[size] = item;
        size++;
    }

    /**
     * Gets the item at the specified index.
     *
     * @param index The index at which the item needs to be returned.
     * @return The item at the specified index.
     * @throws ArrayIndexOutOfBoundsException if the index specified is out of size bound.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return items[index];
    }

    /**
     * Checks if the array is full in size. If it is full it doubles the array size to accommodate more elements.
     * //Note: Made private since not to be exposed to public for direct consumption.
     */
    private void checkIfArrayFullInSize() {
        if (size == items.length) {
            int copy[] = new int[size * 2];
            System.arraycopy(items, 0, copy, 0, size);
            items = copy;
        }
    }

    /**
     * Main method that gets executed on program execution.
     *
     * @param arg The variable arguments passed as stdin input to the program.
     */
    public static void main(String arg[]) {
        ResizeableArray array = new ResizeableArray(4);
        array.append(2); array.append(5); array.append(6); array.append(8);

        System.out.println("Length of the Array with expected size: " + array.items.length);
        System.out.println();
        array.append(9);
        System.out.println("Length of the Array after adding additional elements exceeding the size of the array: " + array.items.length);
        System.out.println();
        array.displayArray();
        array.set(2, 10);
        array.displayArray();
    }
}
