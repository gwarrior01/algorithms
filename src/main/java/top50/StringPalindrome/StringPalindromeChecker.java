package top50.StringPalindrome;

public class StringPalindromeChecker {

    public static boolean isPalindromeIterative(String value) {
        String lowerCaseValue = value.toLowerCase();
        for (int i = 0; i < lowerCaseValue.length() / 2; i++) {
            if (lowerCaseValue.charAt(i) != lowerCaseValue.charAt(lowerCaseValue.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String value) {
        if (value.length() < 2) {
            return true;
        }
        if (Character.toLowerCase(value.charAt(0)) == Character.toLowerCase(value.charAt(value.length() - 1))) {
            return isPalindromeRecursive(value.substring(1, value.length() - 1));
        } else {
            return false;
        }
    }
}
