import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        int[] unsorted1, unsorted2;
        Random rand = new Random();

        //Bubble Sort Demonstration
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

        //Selection Sort Demonstration
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

        //Insertion Sort Demonstration
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

        //Merge Sort Demonstration
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

        //Quick Sort Demonstration
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

        //Quick Sort Demonstration
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

        //Counting Sort Demonstration
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

        //Radix Sort Demonstration
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
    }
}
