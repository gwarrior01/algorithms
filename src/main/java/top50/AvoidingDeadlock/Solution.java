package top50.AvoidingDeadlock;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void performConcurrent(int threadNumber, Object firstMonitor, Object secondMonitor, Runnable work) {
        Object[] monitors = {firstMonitor, secondMonitor};
        Arrays.sort(monitors, Comparator.comparing(Object::hashCode));
        for (int i = 0; i < threadNumber; i++) {
            new Thread(() -> {
                synchronized (monitors[0]) {
                    synchronized (monitors[1]) {
                        work.run();
                    }
                }

            }).start();
        }
    }

    private static void doWork() {
        System.out.println("I`m working");
    }

    public static void main(String[] args) {
        performConcurrent(4, new Object(), new Object(), Solution::doWork);
    }

}
