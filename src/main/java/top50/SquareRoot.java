package top50;

import java.util.function.BinaryOperator;

public class SquareRoot {
    private static BinaryOperator<Double> function = (value, tmp) -> (value / tmp + tmp) / 2.0;

    public static double computeSquareRoot(double value) {
        double epsilon = 1e-15;
        double tmp = value;
        while (Math.abs(tmp - value / tmp) > epsilon * tmp) {
            tmp = function.apply(value, tmp);
        }
        return tmp;
    }
}
