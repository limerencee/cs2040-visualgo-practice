class BubbleSort {

    static void bubbleSort(OrderEnum.Order order, int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 1; j < inputArr.length - i; j++) { //Minus i because number of sorted elements with each pass
                boolean swap = false;
                if (order == OrderEnum.Order.ASC) {
                    if (inputArr[j-1] > inputArr[j]) {
                        swap = true;
                    }
                } else {
                    if (inputArr[j-1] < inputArr[j]) {
                        swap = true;
                    }
                }
                if (swap) {
                    int t = inputArr[j - 1];
                    inputArr[j - 1] = inputArr[j];
                    inputArr[j] = t;
                }
            }
        }
    }

}
