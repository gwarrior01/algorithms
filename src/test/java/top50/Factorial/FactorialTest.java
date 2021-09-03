package top50.Factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

    @Test
    void getFactorialIterative() {
        assertEquals(120, Factorial.getFactorialIterative(5));
    }

    @Test
    void getFactorialRecursive() {
        assertEquals(120, Factorial.getFactorialRecursive(5));
    }
}