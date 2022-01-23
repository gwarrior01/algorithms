package top50.TreeTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class PreOrderTraversal {
    public static void preOrderTraversalRecursive(Node node) {
        if (node == null) {
            return;
        }
        visit(node);
        preOrderTraversalRecursive(node.left);
        preOrderTraversalRecursive(node.right);
    }

    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.add(node);
        Node current;
        while (!nodes.isEmpty()) {
            current = nodes.pollFirst();
            visit(current);
            Optional.ofNullable(current.right).ifPresent(nodes::addFirst);
            Optional.ofNullable(current.left).ifPresent(nodes::addFirst);
        }
    }

    private static void visit(Node node) {
        System.out.print(node.value);
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
        preOrderTraversalRecursive(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
    }
}
