import java.util.Random;

class QuickSort {

    static int partition(OrderEnum.Order order, int[] inputArr, int low, int high) {
        int pivot = inputArr[low];
        int stored = low;

        if (order == OrderEnum.Order.ASC) {
            for (int i = low + 1; i <= high; i++) { //loop the unsorted parts
                //If any element is smaller than pivot, swap with pivot index + 1
                if (inputArr[i] < pivot) {
                    stored++;
                    int t = inputArr[i];
                    inputArr[i] = inputArr[stored];
                    inputArr[stored] = t;
                }
            }
        } else {
            for (int i = low + 1; i <= high; i++) { //loop the unsorted parts
                //If any element is larger than pivot, swap with pivot index + 1
                if (inputArr[i] > pivot) {
                    stored++;
                    int t = inputArr[i];
                    inputArr[i] = inputArr[stored];
                    inputArr[stored] = t;
                }
            }
        }

        //Swap pivot with pivot index + 1 (or swap with itself if there is no hit above)
        int t = inputArr[low];
        inputArr[low] = inputArr[stored];
        inputArr[stored] = t;

        //Return pivot index
        return stored;
    }

    static int randPartition(OrderEnum.Order order, int[] inputArr, int low, int high) {
        //Get random index, and swap with starting index
        Random rand = new Random();
        int r = rand.ints(1, low, high + 1).sum();
        int t = inputArr[low];
        inputArr[low] = inputArr[r];
        inputArr[r] = t;

        return partition(order, inputArr, low, high);
    }

    static void quickSort(OrderEnum.Order order, int[] inputArr, int low, int high) {
        if (low < high) {
            int pivot = partition(order, inputArr, low, high);
            quickSort(order, inputArr, low, pivot - 1); //Sort left subarray
            //pivot is ignored as it is sorted from partition()
            quickSort(order, inputArr, pivot + 1, high); //Sort right subarray
        }
    }

    static void randQuickSort(OrderEnum.Order order, int[] inputArr, int low, int high) {
        if (low < high) {
            int pivot = randPartition(order, inputArr, low, high);
            quickSort(order, inputArr, low, pivot - 1); //Sort left subarray
            //pivot is ignored as it is sorted from partition()
            quickSort(order, inputArr, pivot + 1, high); //Sort right subarray
        }
    }

}
