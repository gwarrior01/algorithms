package top50;

public class ReverseArray {

    public static int[] reverseIterative(int[] inputArray) {
        for (int i = 0; i < inputArray.length / 2; i++) {
            swapArrayElements(inputArray, i, inputArray.length - 1 - i);
        }
        return inputArray;
    }

    private static int[] swapArrayElements(int[] inputArray, int oneElementPosition, int secondElementPosition) {
        int tmp = inputArray[oneElementPosition];
        inputArray[oneElementPosition] = inputArray[secondElementPosition];
        inputArray[secondElementPosition] = tmp;
        return inputArray;
    }

    public static int[] reverseRecursive(int[] inputArray) {
        return reverseRecursive(inputArray, 0, inputArray.length - 1);
    }

    private static int[] reverseRecursive(int[] inputArray, int leftPos, int rightPos) {
        if (leftPos >= rightPos) return inputArray;
        int[] arrayAfterSwap = swapArrayElements(inputArray, leftPos, rightPos);
        return reverseRecursive(arrayAfterSwap, ++leftPos, --rightPos);
    }

}
