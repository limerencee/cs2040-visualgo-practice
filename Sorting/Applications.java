/**
* These are some example applications of practical usage of sorted arrays.
* Assuming that all arrays here are sorted and of type int
*/
import java.util.Arrays;

class Applications {

    /**
    * Search for a specific value k using binary search.
    * Time complexity: O(log n)
    * Space complexity: O(1)
    * @param inputArr Sorted int array
    * @param k Value to be searched
    * @param left Lower bound of the array
    * @param right Upper bound of the array
    * @return Index of k in inputArr, or -1 if not found.
    */
    static int findK(int[] inputArr, int k, int left, int right) {
        //Check that k is even inside the array by checking against the
        //last element
        if (right >= left && k <= inputArr[inputArr.length - 1]) {
            int mid = (left + right + 1) / 2;
            if (inputArr[mid] == k) {
                return mid;
            } else if (inputArr[mid] < k) {
                return findK(inputArr, k, mid, right);
            } else {
                return findK(inputArr, k, left, mid);
            }
        } else {
            return -1;
        }
    }

    /**
    * Find the min/max or the k-th (k > 0) smallest/largest value in array
    * Time complexity: O(1)
    * Space complexity: O(1)
    * @param inputArr Sorted int array
    * @param k k-th smallest/largest value
    * @param findMin true if finding k-th smallest, false if finding k-th largest
    * @return Value of k-th smallest/largest element in inputArr
    */
    static int kthMinMax(int[] inputArr, int k, boolean findMin) {
        if (findMin) {
            return k == 1 ? inputArr[0] : inputArr[0 + (k - 1)];
        } else {
            return k == 1 ? inputArr[inputArr.length - 1] : inputArr[inputArr.length - 1 - (k - 1)];
        }
    }

    /**
    * Remove duplicates in the array
    * Time complexity: O(n)
    * Space complexity: O(k), where k is output array size
    * @param inputArr Sorted int array
    * @return int[] with no duplicate elements
    */
    static int[] removeDuplicates(int[] inputArr) {
        int newArrSize = 0;
        int[] temp = new int[inputArr.length];
        int[] outputArr;

        //Index 0 of input array for reference
        int storedValue = inputArr[0];
        temp[0] = inputArr[0];

        for (int i = 1, j = 1; i < inputArr.length; i++, j++) {
            //If current element is the same as the previous one,
            //loop forward until the next unique element is found
            //or the end of the inputArr is reached.
            if (inputArr[i] == storedValue) {
                int nextIndex = i + 1;
                while (nextIndex < inputArr.length && inputArr[nextIndex] == inputArr[i]) {
                    nextIndex++;
                }
                temp[j] = inputArr[nextIndex];
                i += nextIndex; //jump to next element after the unique element
            } else {
                temp[j] = inputArr[i];
            }
            newArrSize++; //increment final array size
        }

        //Minimum size is 1
        outputArr = new int[newArrSize + 1];
        for (int i = 0; i < newArrSize + 1; i++) {
            outputArr[i] = temp[i];
        }

        return outputArr;
    }

    /**
    * Auxiliary function for countOccurrenceK() to find index of first
    * occurrence of k with binary search
    * @param inputArr Sorted int array
    * @param k Value to search first occurrence of
    * @param left Lower bound of the array
    * @param right Upper bound of the array
    * @return First index of k in inputArr, or -1 if not found.
    */
    static int firstOccurrenceK(int[] inputArr, int k, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            //If no more left path or the next left value < k
            if ((mid == 0 || k > inputArr[mid - 1]) && inputArr[mid] == k) {
                return mid;
            } else if (k > inputArr[mid]) { //k > current mid, go right
                return firstOccurrenceK(inputArr, k, (mid + 1), right);
            } else { //else, k <= current mid, go left
                return firstOccurrenceK(inputArr, k, left, (mid - 1));
            }
        }
        return -1; //k not found
    }

    /**
    * Auxiliary function for countOccurrenceK() to find index of last
    * occurrence of k with binary search
    * @param inputArr Sorted int array
    * @param k Value to search last occurrence of
    * @param left Lower bound of the array
    * @param right Upper bound of the array
    * @return Last index of k in inputArr, or -1 if not found.
    */
    static int lastOccurrenceK(int[] inputArr, int k, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            //If no more right path or the next right value > k
            if ((mid == inputArr.length - 1 || k < inputArr[mid + 1]) && inputArr[mid] == k) {
                return mid;
            } else if (k < inputArr[mid]) { //k < current mid, go left
                return lastOccurrenceK(inputArr, k, left, (mid - 1));
            } else { //k >= current mid, go right
                return lastOccurrenceK(inputArr, k, (mid + 1), right);
            }
        }
        return -1; //k not found
    }

    /**
    * Count the number of occurrence of k in the array
    * Time complexity: O(log n) -> log n binary search
    * Space complexity: O(1)
    * @param inputArr Sorted int array
    * @param k Value to count occurrence of
    * @return Number of times k occurs in inputArr
    */
    static int countOccurrenceK(int[] inputArr, int k) {
        int startIndex = firstOccurrenceK(inputArr, k, 0, inputArr.length - 1);
        if (startIndex == -1) {
            return 0;
        }
        int lastIndex = lastOccurrenceK(inputArr, k, 0, inputArr.length - 1);
        return lastIndex - startIndex + 1;
    }

    /**
    * Find the union of 2 sorted int arrays
    * Time complexity: O(m + n), where m and n are the length of the arrays
    * Space complexity: O(m + n), where m and n are the length of the arrays
    * @param inputArrA Sorted int array
    * @param inputArrB Sorted int array
    * @return Sorted union array of inputArrA and inputArrB
    */
    static int[] setUnion(int[] inputArrA, int[] inputArrB) {
        int aCounter = 0;
        int bCounter = 0;
        int outputArrCounter = 0;
        int[] outputArr = new int[inputArrA.length + inputArrB.length];

        while (aCounter < inputArrA.length && bCounter < inputArrB.length) {
            int a = inputArrA[aCounter];
            int b = inputArrB[bCounter];
            if (a <= b) {
                while (aCounter < inputArrA.length && inputArrA[aCounter] == a) {
                    outputArr[outputArrCounter++] = a;
                    aCounter++;
                }
            } else {
                while (bCounter < inputArrB.length && inputArrB[bCounter] == b) {
                    outputArr[outputArrCounter++] = b;
                    bCounter++;
                }
            }
        }

        //Add the leftovers. Only 1 array will have elements left.
        while (aCounter < inputArrA.length) {
            outputArr[outputArrCounter++] = inputArrA[aCounter++];
        }
        while (bCounter < inputArrB.length) {
            outputArr[outputArrCounter++] = inputArrB[bCounter++];
        }

        return outputArr;
    }

    /**
    * Find the intersection of 2 sorted int arrays
    * Time complexity: O(m + n), where m and n are the length of the arrays
    * Space complexity: O(n), where n is the smaller of the two arrays
    * @param inputArrA Sorted int array
    * @param inputArrB Sorted int array
    * @return Sorted intersection array of inputArrA and inputArrB
    */
    static int[] setIntersection(int[] inputArrA, int[] inputArrB) {
        int aCounter = 0;
        int bCounter = 0;
        int outputArrCounter = 0;
        int shorterLength = inputArrA.length < inputArrB.length ? inputArrA.length : inputArrB.length;
        int[] temp = new int[shorterLength];

        while (aCounter < inputArrA.length && bCounter < inputArrB.length) {
            int a = inputArrA[aCounter];
            int b = inputArrB[bCounter];

            if (b > a) {
                aCounter++;
            } else if (b < a) {
                bCounter++;
            } else {
                temp[outputArrCounter++] = a;
                aCounter++;
                bCounter++;
            }
        }

        int[] outputArr = new int[outputArrCounter];
        for (int i = 0; i < outputArrCounter; i++) {
            outputArr[i] = temp[i];
        }

        return outputArr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 4, 5, 7, 8, 9, 12};
        int[] arr1 = {4, 5, 5, 6, 7, 7};
        int[] output = removeDuplicates(arr);
        System.out.println(Arrays.toString(output));
        System.out.println(findK(arr, 8, 0, arr.length - 1));
        System.out.println(kthMinMax(arr, 3, true));
        System.out.println(countOccurrenceK(arr, 3));
        System.out.println(Arrays.toString(setUnion(arr, arr1)));
        System.out.println(Arrays.toString(setIntersection(arr, arr1)));
    }
}
