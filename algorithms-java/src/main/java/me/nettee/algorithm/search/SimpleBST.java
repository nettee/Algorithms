package me.nettee.algorithm.search;

import com.google.common.base.Preconditions;

public class SimpleBST<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value value;
        int N;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            N = 1;
        }

        @Override
        public String toString() {
            return String.format("<%s, %s>", key, value);
        }
    }

    private Node root;

    public SimpleBST() {
        root = null;
    }

    public boolean isEmpty() {
        return size(root) > 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        Preconditions.checkNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        Preconditions.checkNotNull(key);
        if (node == null) {
            return null;
        }

        int c = key.compareTo(node.key);
        if (c < 0) {
            return get(node.left, key);
        } else if (c > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        Preconditions.checkNotNull(key);
        if (value == null) {
            delete(key);
        } else {
            root = put(root, key, value);
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            // Base case: insert a new key
            return new Node(key, value);
        }

        int c = key.compareTo(node.key);
        if (c < 0) {
            node.left = put(node.left, key, value);
        } else if (c > 0) {
            node.right = put(node.right, key, value);
        } else {
            // Base case: modify value
            node.value = value;
        }

        node.N = size(node.left) + size(node.right) + 1;

        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            throw new IllegalStateException();
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Delete this node.
            // If this node has no more than one child, replace it with its child.
            if (node.left == null) {
                // FIXME update N
                return node.right;
            } else if (node.right == null) {
                // FIXME update N
                return node.left;
            } else {
                // This node has two children.
                Node newNode = min(node.right);
                // Note: deleteMin() must before newNode.left is set!
                newNode.right = deleteMin(node.right);
                newNode.left = node.left;
                node = newNode;
            }
        }

        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            // Base case: no left child
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    String dumpTree() {
        return dumpTree(root);
    }

    private String dumpTree(Node node) {
        if (node == null) {
            return "#";
        } else {
            return String.format("%d{%s,%s}", node.key, dumpTree(node.left), dumpTree(node.right));
        }
    }

}
