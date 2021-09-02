package top50.PrimeNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PrimeNumberCheckerTest {

    @Test
    void isPrimeNumber() {
        assertTrue(PrimeNumberChecker.isPrimeNumber(13));
        assertFalse(PrimeNumberChecker.isPrimeNumber(15));
    }
}