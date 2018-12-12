class SelectionSort {

    static void selectionSort(OrderEnum.Order order, int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            int n = i; //assume index i to be smallest/largest
            for (int j = i + 1; j < inputArr.length; j++) { //loop through remaining elements from i+1 to find next smallest/largest element
                if (order == OrderEnum.Order.ASC) {
                    if (inputArr[j] < inputArr[n]) {
                        n = j; //save the index of smallest element
                    }
                } else {
                    if (inputArr[j] > inputArr[n]) {
                        n = j;
                    }
                }
            }
            int t = inputArr[i];
            inputArr[i] = inputArr[n];
            inputArr[n] = t;
        }
    }

}
