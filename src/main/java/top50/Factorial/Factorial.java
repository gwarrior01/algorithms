package top50.Factorial;

public class Factorial {

    public static int getFactorialIterative(int value) {
        int result = 1;
        while (value > 0) {
            result *= value--;
        }
        return result;
    }

    public static int getFactorialRecursive(int value) {
        if (value == 1) {
            return 1;
        }
        return value * getFactorialRecursive(value - 1);
    }
}
