package top50.IntegerPalindrome;

public class IntegerPalindromeChecker {

    public static boolean isPalindrome(int number) {
        int reversed = 0;
        int inputCopy = number;
        while (number > 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number /= 10;
        }
        return reversed == inputCopy;
    }
}
