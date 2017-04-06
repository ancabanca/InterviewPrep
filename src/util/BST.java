package com.github.ancabanca.interviewprep.util;

    
public class BST<K extends Comparable, V> {
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
        if(n == null)
            return new Node(key, value);
        int cmp = key.compareTo(n.key);
        if(cmp < 0)
            n.left = put(key, value, n.left);
        else if (cmp > 0)
            n.right = put(key, value, n.right);
        else
            n.value = value;
        return n;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        Node(K key, V value) {
            if(key == null || value == null)
                throw new IllegalArgumentException("Keys and values in BST cannot be null");
            this.key = key;
            this.value = value;
        }
    }
}