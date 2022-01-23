package top50.TreeTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class InOrderTraversal {

    public static void inOrderTraversalRecursive(Node node) {
        if (node == null) return;
        inOrderTraversalRecursive(node.left);
        visit(node);
        inOrderTraversalRecursive(node.right);
    }

    public static void inOrderTraversal(Node node) {
        if (node == null) return;
        Deque<Node> nodes = new ArrayDeque<>();
        Deque<Integer> values = new ArrayDeque<>();
        nodes.addFirst(node);
        Node current;
        while (!nodes.isEmpty()) {
            current = nodes.pollFirst();
            values.addFirst(current.value);
            if (current.left == null) {
                process(values.pollFirst());
            }
            if (current.right == null && !values.isEmpty()) {
                process(values.pollFirst());
            }
            Optional.ofNullable(current.right).ifPresent(nodes::addFirst);
            Optional.ofNullable(current.left).ifPresent(nodes::addFirst);
        }
    }

    private static void visit(Node node) {
        process(node.value);
    }

    private static void process(Integer value) {
        System.out.print(value);
    }

    private static class Node {
        private Node left;
        private Node right;
        private final int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        /*             1
                     /  \
                    3    5
                  /  \    \
                 6   8     7
        */

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        inOrderTraversalRecursive(root);
        System.out.println();
        inOrderTraversal(root);
    }
}
