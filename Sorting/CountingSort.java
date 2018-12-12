import java.util.stream.IntStream;

class CountingSort {

    static void countingSort(OrderEnum.Order order, int[] inputArr) {
        //Assume range of integers are from 0-100
        int max = IntStream.of(inputArr).max().getAsInt();
        int countArr[] = new int[max + 1];
        int outputArr[] = new int[inputArr.length];

        //Initialize countArr which counts the number of times an Integer
        //appear and index = integer
        for (int i = 0; i < inputArr.length; i++) {
            countArr[inputArr[i]]++;
        }

        //countArr[i] now stores countArr[i-1] + countArr[i], which contains
        //the actual index of the integer.
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        //For each inputArr[i]:
        //1) Copy the value of inputArr[i]
        //2) Look at countArr[inputArr[i]] to find its index, decrement its
        //   counter (so that repeated values will be place at correct index)
        //3) Store the value into outputArr[countArr[inputArr[i]] - 1]
        for (int i = inputArr.length - 1; i >= 0; i--) {
            int val = inputArr[i];
            int pos = countArr[val]--;
            outputArr[pos - 1] = val;
        }

        if (order == OrderEnum.Order.ASC) {
            //Copy outputArr back into inputArr ascending order.
            for (int i = 0; i < inputArr.length; i++) {
                inputArr[i] = outputArr[i];
            }
        } else {
            //Copy outputArr back into inputArr descending order.
            for (int i = 0, j = inputArr.length - 1; i < inputArr.length; i++, j--) {
                inputArr[j] = outputArr[i];
            }
        }
    }

}
