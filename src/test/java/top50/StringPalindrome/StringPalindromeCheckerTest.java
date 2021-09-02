package top50.StringPalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringPalindromeCheckerTest {

    @Test
    void isPalindromeIterative() {
        assertTrue(StringPalindromeChecker.isPalindromeIterative("TenEt"));
    }

    @Test
    void isPalindromeRecursive() {
        assertTrue(StringPalindromeChecker.isPalindromeRecursive("TenEt"));
    }
}