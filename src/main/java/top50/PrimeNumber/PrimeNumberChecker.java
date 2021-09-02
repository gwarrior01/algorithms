package top50.PrimeNumber;

public class PrimeNumberChecker {

    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) return true;
        if (number < 2 || number % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
