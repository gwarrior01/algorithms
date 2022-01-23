package top50.TreeTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrderTraversal {
    public static void postOrderTraversalRecursive(Node root) {
        if (root == null) return;
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        visit(root);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) return;
        Deque<Node> nodes = new ArrayDeque<>();
        Node current = root;
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                if (current.right != null) {
                    nodes.addFirst(current.right);
                }
                nodes.addFirst(current);
                current = current.left;
            }
            current = nodes.pollFirst();
            if (nodes.isEmpty() || current.right == null || current.right.value != nodes.peekFirst().value) {
                visit(current);
                current = null;
            } else {
                nodes.pollFirst();
                nodes.addFirst(current);
                current = current.right;
            }
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
        postOrderTraversalRecursive(root);
        System.out.println();
        postOrderTraversal(root);
    }
}
