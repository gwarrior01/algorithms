package top50;

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
        Deque<Node> leftNodes = new ArrayDeque<>();
        Deque<Node> rightNodes = new ArrayDeque<>();
        leftNodes.add(node);
        Node current;
        while (!leftNodes.isEmpty() || !rightNodes.isEmpty()) {
            if (!leftNodes.isEmpty()) {
                current = leftNodes.pollFirst();
            } else {
                current = rightNodes.pollLast();
            }
            visit(current);
            Optional.of(current).map(cur -> cur.left).ifPresent(leftNodes::add);
            Optional.of(current).map(cur -> cur.right).ifPresent(rightNodes::add);
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
