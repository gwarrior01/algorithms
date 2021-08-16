package StackWithMax;

public class Container {
    private Stack data = new Stack();
    private Stack maxHolder = new Stack();

    public void push(int value) {
        data.push(value);
        if (maxHolder.size == 0 || value >= maxHolder.peek()) {
            maxHolder.push(value);
        }
    }

    public int pop() {
        if (data.peek() == maxHolder.peek()) {
            maxHolder.pop();
        }
        return data.pop();
    }

    public int max() {
        return maxHolder.peek();
    }

    class Stack {
        private final int initialCapacity = 10;
        private int[] elements = new int[initialCapacity];
        int size = 0;

        private void push(int value) {
            elements[size++] = value;
        }

        private int pop() {
            if (size == 0) throw new RuntimeException("EmptyStack");
            return elements[--size];
        }

        private int peek() {
            if (size == 0) throw new RuntimeException("EmptyStack");
            return elements[size - 1];
        }
    }
}