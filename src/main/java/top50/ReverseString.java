package top50;

public class ReverseString {

    public static String reverseStringIterative(String inputValue) {
        char[] chars = inputValue.toCharArray();
        for (int i = 0, j = chars.length - 1; i != j || i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    public static String reverseStringRecursive(String inputValue) {
        if (inputValue.length() == 1) {
            return inputValue;
        }
        return inputValue.charAt(inputValue.length() - 1) + reverseStringRecursive(inputValue.substring(0, inputValue.length() - 1));
    }
}
