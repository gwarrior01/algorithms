package TreeFromString;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringToTreeConverter {

    public Node<Integer> convertToTreeRecursive(String value) {
        Node<Integer> root = new Node<>(Integer.valueOf(String.valueOf(value.charAt(0))));
        if (value.length() == 1) return root;
        int separatorIndex = getSubTreeSeparatorIndex(value);
        root.left = convertToTreeRecursive(value.substring(2, separatorIndex));
        if (separatorIndex != value.length() - 1) {
            root.right = convertToTreeRecursive(value.substring(separatorIndex + 2, value.length() - 1));
        }
        return root;
    }

    private int getSubTreeSeparatorIndex(String value) {
        Deque<Character> bracketsHolder = new ArrayDeque<>();
        for (int i = value.indexOf('('); i < value.length(); i++) {
            if (value.charAt(i) == '(') {
                bracketsHolder.addFirst('(');
            } else if (value.charAt(i) == ')') {
                bracketsHolder.removeFirst();
                if (bracketsHolder.isEmpty()) return i;
            }
        }
        return value.length() - 1;
    }

    class Node<T> {
        Node left;
        Node right;
        T value;

        Node(T value) {
            this.value = value;
        }
    }
}
