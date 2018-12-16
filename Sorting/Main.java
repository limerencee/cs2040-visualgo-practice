import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        int[] unsorted1, unsorted2;
        Random rand = new Random();

        /**
        * Bubble Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|     Bubble Sort Demo      |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        BubbleSort.bubbleSort(OrderEnum.Order.ASC, unsorted1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        BubbleSort.bubbleSort(OrderEnum.Order.DESC, unsorted2);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Selection Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|    Selection Sort Demo    |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        SelectionSort.selectionSort(OrderEnum.Order.ASC, unsorted1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        SelectionSort.selectionSort(OrderEnum.Order.DESC, unsorted2);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Insertion Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|    Insertion Sort Demo    |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        InsertionSort.insertionSort(OrderEnum.Order.ASC, unsorted1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        InsertionSort.insertionSort(OrderEnum.Order.DESC, unsorted2);
        System.out.println("Ascending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Merge Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|    Insertion Sort Demo    |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        MergeSort.mergeSort(OrderEnum.Order.ASC, unsorted1, 0, unsorted1.length - 1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        MergeSort.mergeSort(OrderEnum.Order.DESC, unsorted2, 0, unsorted2.length - 1);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Quick Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|      Quick Sort Demo      |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        QuickSort.quickSort(OrderEnum.Order.ASC, unsorted1, 0, unsorted1.length - 1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        QuickSort.quickSort(OrderEnum.Order.DESC, unsorted2, 0, unsorted2.length - 1);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Quick Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|     R. Quick Sort Demo    |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        QuickSort.randQuickSort(OrderEnum.Order.ASC, unsorted1, 0, unsorted1.length - 1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        QuickSort.randQuickSort(OrderEnum.Order.DESC, unsorted2, 0, unsorted2.length - 1);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Counting Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|     Counting Sort Demo    |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        CountingSort.countingSort(OrderEnum.Order.ASC, unsorted1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        CountingSort.countingSort(OrderEnum.Order.DESC, unsorted2);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Radix Sort Demonstration
        */
        unsorted1 = rand.ints(12, 0, 100000).toArray();
        unsorted2 = rand.ints(12, 0, 100000).toArray();
        System.out.println("=============================");
        System.out.println("|      Radix Sort Demo      |");
        System.out.println("=============================");
        System.out.println("Unsorted #1 array: " + Arrays.toString(unsorted1));
        RadixSort.radixSort(OrderEnum.Order.ASC, unsorted1);
        System.out.println("Ascending: " + Arrays.toString(unsorted1));
        System.out.println();
        System.out.println("Unsorted #2 array: " + Arrays.toString(unsorted2));
        RadixSort.radixSort(OrderEnum.Order.DESC, unsorted2);
        System.out.println("Descending: " + Arrays.toString(unsorted2));
        System.out.println("\n");

        /**
        * Various applications for a sorted list.
        */
        int lowerBound = 0;
        int upperBound = 100;
        int arraySize = 12;
        int randomK = rand.ints(1, lowerBound, upperBound + 1).sum();
        int[] arr1 = rand.ints(arraySize, lowerBound, upperBound + 1).sorted().toArray();
        int[] arr2 = rand.ints(arraySize, lowerBound, upperBound + 1).sorted().toArray();
        int[] noDupeArr1 = Applications.removeDuplicates(arr1);
        int[] noDupeArr2 = Applications.removeDuplicates(arr2);

        System.out.println("\n====================================================================\n");
        System.out.println("Random sorted arr1: " + Arrays.toString(arr1));
        System.out.println("Random sorted arr2: " + Arrays.toString(arr2));
        System.out.println("\n====================================================================\n");
        System.out.println("Removing duplicates from arr1: " + Arrays.toString(noDupeArr1));
        System.out.println("Removing duplicates from arr2: " + Arrays.toString(noDupeArr2));
        System.out.println("\n====================================================================\n");
        System.out.println("Finding " + randomK + " from arr1: " + Applications.findK(arr1, randomK, 0, arraySize - 1));
        System.out.println("Finding " + randomK + " from arr2: " + Applications.findK(arr2, randomK, 0, arraySize - 1));
        System.out.println("\n====================================================================\n");
        for (int i = 1; i < 6; i++) {
            System.out.println("Finding " + i + "-th maximum value from arr1: " + Applications.kthMinMax(noDupeArr1, i, false));
        }
        System.out.println();
        for (int i = 1; i < 6; i++) {
            System.out.println("Finding " + i + "-th minimum value from arr2: " + Applications.kthMinMax(noDupeArr2, i, true));
        }
        System.out.println("\n====================================================================\n");
        System.out.println("Finding number of occurrence(s) of " + randomK + " from arr1: " + Applications.countOccurrenceK(arr1, randomK));
        System.out.println("Finding number of occurrence(s) of " + randomK + " from arr2: " + Applications.countOccurrenceK(arr2, randomK));
        System.out.println("\n====================================================================\n");
        System.out.println("Finding the set union of arr1 and arr2: " + Arrays.toString(Applications.setUnion(arr1, arr2)));
        System.out.println("Finding the set intersection of arr1 and arr2: " + Arrays.toString(Applications.setIntersection(arr1, arr2)));
        System.out.println("\n====================================================================\n");
        System.out.println("Finding a pair (x, y) that sums to " + randomK + " from arr1: " + Arrays.toString(Applications.findPair(arr1, randomK)));
        System.out.println("Finding a pair (x, y) that sums to " + randomK + " from arr2: " + Arrays.toString(Applications.findPair(arr2, randomK)));
        System.out.println("\n====================================================================\n");
    }
}
