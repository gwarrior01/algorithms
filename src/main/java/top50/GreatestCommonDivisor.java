package top50;

public class GreatestCommonDivisor {

    public static int euclideanAlgorithm(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return euclideanAlgorithm(secondNumber, firstNumber % secondNumber);
    }

    public static int binaryAlgorithm(int firstNumber, int secondNumber) {
        if (firstNumber == 0) return secondNumber;
        if (secondNumber == 0) return firstNumber;
        if (firstNumber == 1 || secondNumber == 1) return 1;
        if (firstNumber == secondNumber) return firstNumber;
        if (isEven(firstNumber)) {
            if (isEven(secondNumber)) {
                return 2 * binaryAlgorithm(firstNumber >> 1, secondNumber >> 1);
            } else {
                return binaryAlgorithm(firstNumber >> 1, secondNumber);
            }
        }
        if (isEven(secondNumber)) {
            if (isOdd(firstNumber)) return binaryAlgorithm(firstNumber, secondNumber >> 1);
        }
        if (firstNumber > secondNumber) {
            return binaryAlgorithm((firstNumber - secondNumber) >> 1, secondNumber);
        } else {
            return binaryAlgorithm((secondNumber - firstNumber) >> 1, firstNumber);
        }
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }

    private static boolean isOdd(int value) {
        return value % 2 != 0;
    }
}
