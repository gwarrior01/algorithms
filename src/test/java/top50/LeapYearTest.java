package top50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeapYearTest {

    @Test
    void isLeap() {
        assertTrue(LeapYear.isLeap(2020));
        assertTrue(LeapYear.isLeap(1904));
        assertFalse(LeapYear.isLeap(1900));
    }
}