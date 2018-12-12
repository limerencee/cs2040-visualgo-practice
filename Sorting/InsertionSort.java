class InsertionSort {

    static void insertionSort(OrderEnum.Order order, int[] inputArr) {
        for (int i = 1; i < inputArr.length; i++) {
            int toSort = inputArr[i]; //store a copy of element to insert
            int j = i - 1; //look through all elements before the current one
            if (order == OrderEnum.Order.ASC) {
                //if previous element is bigger than current element,
                //copy it into current element
                while ((j >= 0) && (inputArr[j] > toSort)) {
                    inputArr[j + 1] = inputArr[j];
                    j--;
                }
            } else {
                while ((j >= 0) && (inputArr[j] < toSort)) {
                    inputArr[j + 1] = inputArr[j];
                    j--;
                }
            }
            //Insertion point is at j + 1, either:
            //1) j = -1 (which is j = 0)
            //2) while loop inputArr[j] > toSort condition fails
            inputArr[j + 1] = toSort;
        }
    }

}
