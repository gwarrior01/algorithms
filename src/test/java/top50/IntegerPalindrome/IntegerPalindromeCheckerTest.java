package top50.IntegerPalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerPalindromeCheckerTest {

    @Test
    void isPalindrome() {
        assertTrue(IntegerPalindromeChecker.isPalindrome(1234321));
    }
}