package top50.ArmstrongNumber;

public class ArmstrongChecker {

    public static boolean isArmstrongNumber(int number) {
        int result = 0;
        int inputCopy = number;
        while (number > 0) {
            int remainder = number % 10;
            result += Math.pow(remainder, 3);
            number /= 10;
        }
        return inputCopy == result;
    }
}
