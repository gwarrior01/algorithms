package TreeFromString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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

        public String inOrderToString() {
            StringBuilder sb = new StringBuilder();
            return inOrderRecursive(this, sb);
        }

        private String inOrderRecursive(Node<T> node, StringBuilder sb) {
            if (node == null) return "";
            inOrderRecursive(node.left, sb);
            sb.append(node.value);
            inOrderRecursive(node.right, sb);
            return sb.toString();
        }

        public String levelOrderToString() {
            StringBuilder sb = new StringBuilder();
            Queue<Node<T>> queue = new ArrayDeque<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node<T> node = queue.poll();
                sb.append(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
//                Optional.ofNullable(node.left).ifPresent(left -> queue.add(left));
//                Optional.ofNullable(node.right).ifPresent(right -> queue.add(right));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        StringToTreeConverter stringToTreeConverter = new StringToTreeConverter();
        Node<Integer> tree = stringToTreeConverter.convertToTreeRecursive("4(2(3)(1))(6(5))");
        System.out.println(tree.inOrderToString());
        System.out.println(tree.levelOrderToString());
    }
}
