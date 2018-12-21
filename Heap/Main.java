import java.util.Random;

class Main {

    public static void main(String[] args) {

        Random rand = new Random();

        /**
        * Max Heap demo
        */
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        int[] intArr1 = rand.ints(11, 0, 100_000).toArray();

        System.out.println("\n=========================================\n");
        System.out.println("Maximum Heap Demo:\n");
        for (int i = 0; i < intArr1.length; i++) {
            System.out.println("Inserting: " + intArr1[i]);
            maxHeap.insert(intArr1[i]);
        }

        System.out.println("\n=========================================\n");
        System.out.println("Printing heap:\n");
        maxHeap.printHeap();

        System.out.println("\n=========================================\n");
        System.out.println("Maximum Heap Sort:\n");
        for (int i = 0; i < intArr1.length; i++) {
            System.out.println("Maximum value extracted = " + maxHeap.extractMax());
        }


        /**
        * Min Heap demo
        */
        MaxHeap<Integer> minHeap = new MaxHeap<>();
        int[] intArr2 = rand.ints(11, 0, 100_000).toArray();

        System.out.println("\n=========================================\n");
        System.out.println("Minimum Heap Demo:\n");
        for (int i = 0; i < intArr2.length; i++) {
            System.out.println("Inserting: " + intArr2[i]);
            minHeap.insert(-1 * intArr2[i]);
        }

        System.out.println("\n=========================================\n");
        System.out.println("Printing heap:\n");
        minHeap.printHeap();

        System.out.println("\n=========================================\n");
        System.out.println("Minimum Heap Sort:\n");
        for (int i = 0; i < intArr2.length; i++) {
            System.out.println("Minimum value extracted = " + minHeap.extractMax() * -1);
        }
    }

}
