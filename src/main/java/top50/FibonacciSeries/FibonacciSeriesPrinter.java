package top50.FibonacciSeries;

public class FibonacciSeriesPrinter {

    public static void printFibonacciSeriesBeforeTo(int beforeValue) {
        int current = 1;
        int previous = 0;

        while (current < beforeValue) {
            System.out.print(current + " ");
            int tmp = current;
            current = current + previous;
            previous = tmp;
        }
    }
}