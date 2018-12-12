import java.util.stream.IntStream;
import java.util.Arrays;

class RadixSort {

    static void radixCountSort(OrderEnum.Order order, int[] inputArr, int rad) {
        //Assume integers are non-negative
        int countArr[] = new int[10];
        int outputArr[] = new int[inputArr.length];
        Arrays.fill(countArr, 0);

        //Initialize countArr which counts the number of times an Integer
        //appear and index = integer. Only looking at the relevant digit
        //based on the supplied rad param
        if (order == OrderEnum.Order.ASC) {
            for (int i = 0; i < inputArr.length; i++) {
                countArr[(inputArr[i] / rad) % 10]++;
            }
        } else {
            for (int i = 0; i < inputArr.length; i++) {
                countArr[9 - (inputArr[i] / rad) % 10]++;
            }
        }

        //countArr[i] now stores countArr[i-1] + countArr[i], which contains
        //the actual index of the integer.
        for (int i = 1; i < 10; i++) {
            countArr[i] += countArr[i - 1];
        }

        //For each inputArr[i]:
        //1) Copy the value of inputArr[i]
        //2) Look at countArr[inputArr[i]] to find its index, decrement its
        //   counter (so that repeated values will be place at correct index)
        //3) Store the value into outputArr[countArr[inputArr[i]] - 1]
        if (order == OrderEnum.Order.ASC) {
            for (int i = inputArr.length - 1; i >= 0; i--) {
                int val = (inputArr[i] / rad) % 10;
                int pos = countArr[val]--;
                outputArr[pos - 1] = inputArr[i];
            }
        } else {
            for (int i = inputArr.length - 1; i >= 0; i--) {
                int val = (inputArr[i] / rad) % 10;
                int pos = countArr[9 - val]--;
                outputArr[pos - 1] = inputArr[i];
            }
        }

        //Copy outputArr back into inputArr
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = outputArr[i];
        }
    }

    static void radixSort(OrderEnum.Order order, int[] inputArr) {
        int max = IntStream.of(inputArr).max().getAsInt();

        for (int i = 1; (max / i) > 0; i *= 10) {
            radixCountSort(order, inputArr, i);
        }
    }

}
