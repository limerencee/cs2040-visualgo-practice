/**
* These are some example applications of practical usage of sorted arrays.
* Assuming that all arrays here are sorted and of type int
*/
import java.util.ArrayList;

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
            int mid = left + right - left / 2;
            if (inputArr[mid] == k) {
                return mid;
            } else if (inputArr[mid] > k) {
                //search left
                return findK(inputArr, k, left, mid - 1);
            } else {
                //search right
                return findK(inputArr, k, mid + 1, right);
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
        int outputArrCounter = 0;
        ArrayList<Integer> outputArr = new ArrayList<>();

        //Index 0 of input array for reference
        int storedValue = inputArr[0];
        outputArr.add(outputArrCounter++, inputArr[0]);

        for (int i = 1; i < inputArr.length; i++) {
            //If current element is the same as the previous one,
            //loop forward until the next unique element is found
            //or the end of the inputArr is reached.
            if (inputArr[i] == storedValue) {
                int nextIndex = i + 1;
                while (nextIndex < inputArr.length && inputArr[nextIndex] == storedValue) {
                    nextIndex++;
                }

                //Add element if the while loop terminated not because of reaching end of index
                if (nextIndex != inputArr.length) {
                    outputArr.add(outputArrCounter++, inputArr[nextIndex]);
                    storedValue = inputArr[nextIndex];
                }
                i = nextIndex; //set pointer to next element after the unique element
            } else {
                outputArr.add(outputArrCounter++, inputArr[i]);
                storedValue = inputArr[i];
            }
        }

        return outputArr.stream().mapToInt(i -> i).toArray();
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
        //int[] outputArr = new int[inputArrA.length + inputArrB.length];
        ArrayList<Integer> outputArr = new ArrayList<>();

        while (aCounter < inputArrA.length && bCounter < inputArrB.length) {
            int a = inputArrA[aCounter];
            int b = inputArrB[bCounter];
            if (a == b) {
                //Ignoring duplicates
                outputArr.add(outputArrCounter++, a);
                while (aCounter < inputArrA.length && inputArrA[aCounter] == a) {
                    aCounter++;
                }
                while (bCounter < inputArrB.length && inputArrB[bCounter] == b) {
                    bCounter++;
                }
            } else {
                if (a < b) {
                    outputArr.add(outputArrCounter++, a);
                    while (aCounter < inputArrA.length && inputArrA[aCounter] == a) {
                        aCounter++;
                    }
                } else {
                    //Ignoring duplicates
                    outputArr.add(outputArrCounter++, b);
                    while (bCounter < inputArrB.length && inputArrB[bCounter] == b) {
                        bCounter++;
                    }
                }
            }
        }

        //Add the leftovers. Only 1 array will have elements left.
        int c = outputArr.get(outputArrCounter-1);
        while (aCounter < inputArrA.length) {
            if (inputArrA[aCounter] == c) {
                aCounter++;
            } else {
                outputArr.add(outputArrCounter++, inputArrA[aCounter++]);
            }
        }

        while (bCounter < inputArrB.length) {
            if (inputArrB[bCounter] == c) {
                bCounter++;
            } else {
                outputArr.add(outputArrCounter++, inputArrB[bCounter++]);
            }
        }

        return outputArr.stream().mapToInt(i -> i).toArray();
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
        ArrayList<Integer> outputArr = new ArrayList<>();

        while (aCounter < inputArrA.length && bCounter < inputArrB.length) {
            int a = inputArrA[aCounter];
            int b = inputArrB[bCounter];

            if (b > a) {
                aCounter++;
            } else if (b < a) {
                bCounter++;
            } else {
                aCounter++;
                bCounter++;
                //Check if previous element in output array is same as the current element
                if (outputArrCounter > 0) {
                    int c = outputArr.get(outputArrCounter - 1);
                    if (c == a) {
                        continue;
                    }
                }
                outputArr.add(outputArrCounter++, a);
            }
        }

        return outputArr.stream().mapToInt(i -> i).toArray();
    }

    /**
    * Given an int z, find int x and int y such that x + y = z
    * Time complexity: O(n)
    * Space complexity: O(1)
    * @param inputArr Sorted int array
    * @param z Value to find a pair of
    * @return int[2] which represents int x and int y, {-1, -1} if x and y does not exist
    */
    static int[] findPair(int[] inputArr, int z) {
        int xCounter = 0;
        int yCounter = inputArr.length - 1;
        int[] output = {-1, -1};

        while (xCounter < inputArr.length && yCounter >= 0) {
            int x = inputArr[xCounter];
            int y = inputArr[yCounter];
            if (x + y == z) {
                output[0] = x;
                output[1] = y;
                return output;
            } else if (z - x > y) {
                xCounter++;
            } else {
                yCounter--;
            }
        }
        return output;
    }

}
