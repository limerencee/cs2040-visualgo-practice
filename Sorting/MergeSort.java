class MergeSort {

    static void mergeSort(OrderEnum.Order order, int[] inputArr, int low, int high) {
        if (low < high) { //Base case low >= high (0 or 1 element)
            int mid = (low + high) / 2;
            mergeSort(order, inputArr, low, mid);
            mergeSort(order, inputArr, mid + 1, high);
            merge(order, inputArr, low, mid, high);
        }
    }

    static void merge(OrderEnum.Order order, int[] inputArr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] outputArr = new int[high - low + 1];
        int index = 0;

        if (order == OrderEnum.Order.ASC) {
            while (left <= mid && right <= high) { //prevent left or right out of bounds
                outputArr[index++] = inputArr[left] <= inputArr[right]
                    ? inputArr[left++] : inputArr[right++];
            }
        } else {
            while (left <= mid && right <= high) { //prevent left or right out of bounds
                outputArr[index++] = inputArr[left] >= inputArr[right]
                    ? inputArr[left++] : inputArr[right++];
            }
        }

        //leftover from left
        while (left <= mid) {
            outputArr[index++] = inputArr[left++];
        }

        //leftover from right
        while (right <= high) {
            outputArr[index++] = inputArr[right++];
        }

        //Copying over to original array
        for (int i = 0; i < index; i++) {
            inputArr[low + i] = outputArr[i];
        }

    }

}
