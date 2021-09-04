package top50;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicateFromIntArray(int[] inputArray) {
        int[] workArray = new int[inputArray.length];
        System.arraycopy(inputArray, 0, workArray, 0, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < workArray.length; i++) {
            if (workArray[i - 1] != workArray[i]) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[workArray.length - 1];
        int[] result = new int[j];
        System.arraycopy(workArray, 0, result, 0, j);
        return result;
    }

    public static char[] removeDuplicateFromCharArray(char[] inputArray) {
        char[] workArray = new char[inputArray.length];
        System.arraycopy(inputArray, 0, workArray, 0, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < workArray.length; i++) {
            if (workArray[i - 1] != workArray[i]) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[workArray.length - 1];
        char[] result = new char[j];
        System.arraycopy(workArray, 0, result, 0, j);
        return result;
    }

    public static String[] removeDuplicateFromStringArray(String[] inputArray) {
        String[] workArray = new String[inputArray.length];
        System.arraycopy(inputArray, 0, workArray, 0, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < workArray.length; i++) {
            if (!workArray[i - 1].equals(workArray[i])) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[workArray.length - 1];
        String[] result = new String[j];
        System.arraycopy(workArray, 0, result, 0, j);
        return result;
    }

    public static <T> T[] removeDuplicateFromArray(T[] inputArray, Class<?> classOfArrayElement, BiPredicate<T, T> predicate) {
        T[] workArray = (T[]) Array.newInstance(classOfArrayElement, inputArray.length);
        System.arraycopy(inputArray, 0, workArray, 0, inputArray.length);
        Arrays.sort(workArray);
        int j = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (predicate.test(workArray[i - 1], workArray[i])) workArray[j++] = workArray[i - 1];
        }
        workArray[j++] = workArray[inputArray.length - 1];
        T[] result = (T[]) Array.newInstance(classOfArrayElement, j);
        System.arraycopy(workArray, 0, result, 0, j);
        return result;
    }

}
