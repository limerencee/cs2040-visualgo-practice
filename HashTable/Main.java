import java.util.Random;

class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        /**
        * Open Addressing - Linear Probing Demo
        */
        HashTableOALinearProbe<Integer, Integer> linearProbe = new HashTableOALinearProbe<>();
        int keys[] = rand.ints(15, 0, 100).toArray();
        int values[] = rand.ints(15, 0, 100).toArray();

        System.out.println("\n=========================================\n");
        System.out.println("Open Addressing - Linear Probing Demo:\n");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Inserting <" + keys[i] + ", " + values[i] + ">: " + linearProbe.insert(keys[i], values[i]));
        }
        System.out.println("\n=========================================\n");
        System.out.println("Printing Stored Data:\n");
        linearProbe.print();
        System.out.println("\n=========================================\n");
        System.out.println("Hash table size = " + linearProbe.size());
        System.out.println("\n=========================================\n");
        System.out.println("Printing Key-Pairs:\n");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Retrieving value of Key <" + keys[i] + ">: " + linearProbe.get(keys[i]));
        }

        /**
        * Open Addressing - Quadratic Probing Demo
        */
        HashTableOAQuadraticProbe<Integer, Integer> quadraticProbe = new HashTableOAQuadraticProbe<>();
        int keys1[] = rand.ints(15, 0, 100).toArray();
        int values1[] = rand.ints(15, 0, 100).toArray();

        System.out.println("\n=========================================\n");
        System.out.println("Open Addressing - Quadratic Probing Demo:\n");
        for (int i = 0; i < keys1.length; i++) {
            System.out.println("Inserting <" + keys1[i] + ", " + values1[i] + ">: " + quadraticProbe.insert(keys1[i], values1[i]));
        }
        System.out.println("\n=========================================\n");
        System.out.println("Printing Stored Data:\n");
        quadraticProbe.print();
        System.out.println("\n=========================================\n");
        System.out.println("Hash table size = " + quadraticProbe.size());
        System.out.println("\n=========================================\n");
        System.out.println("Printing Key-Pairs:\n");
        for (int i = 0; i < keys1.length; i++) {
            System.out.println("Retrieving value of Key <" + keys1[i] + ">: " + quadraticProbe.get(keys1[i]));
        }

        /**
        * Open Addressing - Double Hashing Demo
        */
        HashTableOADoubleHash<Integer, Integer> doubleHashProbe = new HashTableOADoubleHash<>();
        int keys2[] = rand.ints(15, 0, 100).toArray();
        int values2[] = rand.ints(15, 0, 100).toArray();

        System.out.println("\n=========================================\n");
        System.out.println("Open Addressing - Double Hashing Demo:\n");
        for (int i = 0; i < keys2.length; i++) {
            System.out.println("Inserting <" + keys2[i] + ", " + values2[i] + ">: " + doubleHashProbe.insert(keys2[i], values2[i]));
        }
        System.out.println("\n=========================================\n");
        System.out.println("Printing Stored Data:\n");
        doubleHashProbe.print();
        System.out.println("\n=========================================\n");
        System.out.println("Hash table size = " + doubleHashProbe.size());
        System.out.println("\n=========================================\n");
        System.out.println("Printing Key-Pairs:\n");
        for (int i = 0; i < keys2.length; i++) {
            System.out.println("Retrieving value of Key <" + keys2[i] + ">: " + doubleHashProbe.get(keys2[i]));
        }

        /**
        * Separate Chaining Demo
        */
        HashTableSC<Integer, Integer> separateChain = new HashTableSC<>();
        int keys3[] = {0, 6007, 12014, 18021, 3, 4};
        int values3[] = {5, 3, 2, 1, 4, 1};

        System.out.println("\n=========================================\n");
        System.out.println("Separate Chaining Demo:\n");
        for (int i = 0; i < keys3.length; i++) {
            System.out.println("Inserting <" + keys3[i] + ", " + values3[i] + ">: " + separateChain.insert(keys3[i], values3[i]));
        }
        System.out.println("\n=========================================\n");
        System.out.println("Printing Stored Data:");
        separateChain.print();
        System.out.println("\nRemoving elements from the LinkedList of index 0:\n");
        separateChain.remove(6007);
        System.out.println("\nPrinting Stored Data:");
        separateChain.print();
        System.out.println("\n=========================================\n");
        System.out.println("Hash table size = " + separateChain.size());
        System.out.println("\n=========================================\n");
        System.out.println("Printing Key-Pairs:\n");
        for (int i = 0; i < keys3.length; i++) {
            System.out.println("Retrieving value of Key <" + keys3[i] + ">: " + separateChain.get(keys3[i]));
        }
        System.out.println("\n=========================================\n");

    }

}
