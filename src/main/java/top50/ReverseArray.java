package top50;

public class ReverseArray {

    public static int[] reverseIterative(int[] inputArray) {
        for (int i = 0; i < inputArray.length / 2; i++) {
            int tmp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length - 1 - i];
            inputArray[inputArray.length - 1 - i] = tmp;
        }
        return inputArray;
    }

}
