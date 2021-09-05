package top50;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicateFromIntArray(int[] inputArray) {
        if (inputArray == null || inputArray.length < 2) return inputArray;
        int[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < workArray.length; i++) {
            if (workArray[i - 1] != workArray[i]) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[workArray.length - 1];
        if (j == inputArray.length) {
            return inputArray;
        } else {
            return Arrays.copyOf(workArray, j);
        }
    }

    public static char[] removeDuplicateFromCharArray(char[] inputArray) {
        if (inputArray == null || inputArray.length < 2) return inputArray;
        char[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < workArray.length; i++) {
            if (workArray[i - 1] != workArray[i]) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[workArray.length - 1];
        if (j == inputArray.length) {
            return inputArray;
        } else {
            return Arrays.copyOf(workArray, j);
        }
    }

    public static <T> T[] removeDuplicateFromArray(T[] inputArray) {
        if (inputArray == null || inputArray.length < 2) return inputArray;
        T[] workArray = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (!workArray[i - 1].equals(workArray[i])) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[inputArray.length - 1];
        if (j == inputArray.length) {
            return inputArray;
        } else {
            return Arrays.copyOf(workArray, j);
        }
    }

}
