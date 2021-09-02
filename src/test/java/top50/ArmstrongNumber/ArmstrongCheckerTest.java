package top50.ArmstrongNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmstrongCheckerTest {

    @Test
    void isArmstrongNumber() {
        assertTrue(ArmstrongChecker.isArmstrongNumber(153));
    }
}