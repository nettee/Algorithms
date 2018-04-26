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
        // TODO
        throw new UnsupportedOperationException();
    }

}
