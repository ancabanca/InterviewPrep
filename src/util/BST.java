package com.github.ancabanca.interviewprep.util;

import java.util.LinkedList;
import java.util.Queue;

public class BST<K extends Comparable, V> {
    private static final boolean BLACK = false;
    private static final boolean RED   = true;
    private Node root;

    public V get(K key) {
        Node n = root;
        while(n != null) {
            int cmp = key.compareTo(n.key);
            if(cmp < 0)
                n = n.left;
            else if(cmp > 0)
                n = n.right;
            else
                return n.value;
        }
        return null;
    }

    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private Node put(K key, V value, Node n) {
        if(n == null) return new Node(key, value, RED);

        int cmp = key.compareTo(n.key);
        if(cmp < 0)       n.left  = put(key, value, n.left);
        else if (cmp > 0) n.right = put(key, value, n.right);
        else              n.value = value;
        n.count = 1 + size(n.left) + size(n.right);

        // red-black BST balancing logic
        if(isRed(n.right) && !isRed(n.left))     n = rotateLeft(n);
        if(isRed(n.left)  && isRed(n.left.left)) n = rotateRight(n);
        if(isRed(n.left)  && isRed(n.right))     flipColors(n);

        return n;
    }

    private boolean isRed(Node n) {
        if(n == null) return false;
        return n.color == RED;
    }

    private Node rotateLeft(Node n) {
        Node r = n.right;
        n.right = r.left;
        r.left = n;
        r.color = n.color;
        n.color = RED;
        return r;
    }

    private Node rotateRight(Node n) {
        Node r = n.left;
        n.left = r.right;
        r.right = n;
        r.color = n.color;
        n.color = RED;
        return r;
    }

    private void flipColors(Node n) {
        n.left.color  = BLACK;
        n.right.color = BLACK;
        n.color = RED;
    }

    public K min() {
        Node n = root;
        if(n == null)
            return null;
        while(n.left != null)
            n = n.left;
        return n.key;
    }

    public K max() {
        Node n = root;
        if(n == null)
            return null;
        while(n.right != null)
            n = n.right;
        return n.key;
    }

    public K floor(K key) {
        Node n = floor(key, root);
        if(n == null)
            return null;
        return n.key;
    }

    private Node floor(K key, Node n) {
        if(n == null) return null;

        int cmp = key.compareTo(n.key);
        if(cmp == 0) return n;
        if(cmp < 0)  return floor(key, n.left);
        // else
        Node f = floor(key, n.right);
        if(f != null)
            return f;
        else
            return n;
    }

    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if(n == null)
            return 0;
        return n.count;
    }

    // the number of keys < key
    public int rank(K key) {
        return rank(key, root);
    }

    private int rank(K key, Node n) {
        if(n == null)
            return 0;
        int cmp = key.compareTo(n.key);
        if(cmp < 0)
            return rank(key, n.left);
        else if(cmp > 0)
            return 1 + size(n.left) + rank(key, n.right);
        else
            return size(n.left);
    }

    public Iterable<K> keys() {
        Queue<K> queue = new LinkedList<K>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node n, Queue<K> q) {
        if(n == null)
            return;
        inorder(n.left, q);
        q.add(n.key);
        inorder(n.right, q);
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int count;
        private boolean color;

        Node(K key, V value, boolean color) {
            if(key == null || value == null)
                throw new IllegalArgumentException("Keys and values in BST cannot be null");
            this.key   = key;
            this.value = value;
            this.color = color;
            this.count = 1;
        }
    }
}