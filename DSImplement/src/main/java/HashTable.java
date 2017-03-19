import java.util.Arrays;

/**
 * Implementation of a Hash table.
 *
 * @author Rushikesh Paradkar
 */
public class HashTable {

    private String[] array;
    private int size;
    private int numberOfElements;

    /**
     * Constructor for creating an instance of a {@link HashTable}.
     *
     * @param size The size of the Hashtable to be created.
     */
    HashTable(final int size) {
        this.size = size;
        array = new String[size];
        numberOfElements = 0;
        Arrays.fill(array, "-1");
    }

    /**
     * Simple Hash Function.
     *
     * @param stringsForArray The array elements that are needed to be stored by hashing.
     * @param theArray        The array elements stored after hashing.
     */
    public void hashFunctionOne(final String[] stringsForArray, final String[] theArray) {

        for (int i = 0; i < stringsForArray.length; i++) {
            final String newElement = stringsForArray[i];
            theArray[Integer.parseInt(newElement)] = newElement;
        }
    }

    /**
     * Helper method that displays the Hash Table.
     */
    public void displayHashTable() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {

                System.out.format("| %3s " + " ", n);

            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                if (array[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", array[n]));
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
        }
    }


    /**
     * Main method for implementation execution.
     *
     * @param args The input to be taken from the user for the
     *             implementation and demo (Not required for this example).
     */
    public static void main(String args[]) {
        HashTable hashTable = new HashTable(30);
        final String[] elementsToAdd = {"1", "7", "13", "22", "28"};
        hashTable.hashFunctionOne(elementsToAdd, hashTable.array);
        hashTable.displayHashTable();
    }
}