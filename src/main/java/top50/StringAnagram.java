package top50;

import java.util.Arrays;

public class StringAnagram {

    public static boolean isStringAnagramSort(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) return false;
        if (firstString.equals(secondString)) return true;

        var firstChars = firstString.toCharArray();
        var secondChars = secondString.toCharArray();
        Arrays.sort(firstChars);
        Arrays.sort(secondChars);
        return Arrays.equals(firstChars, secondChars);
    }

    public static boolean isStringAnagram(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) return false;
        if (firstString.equals(secondString)) return true;

        int[] count = new int[256];
        for (int i = 0; i < firstString.length(); i++) {
            count[firstString.charAt(i)]++;
            count[secondString.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
