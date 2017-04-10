package com.github.ancabanca.interviewprep.util;

public class HashTable<K,V> {
    private int M = 97;
    private Node[] table;

    // resizing array can be implemented
    // without resizing, search is done in O(N/M)
    public HashTable() {
        table = new Node[M];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % M;
        for(Node n = table[hash]; n != null; n = n.next)
            if(key.equals(n.key)) {
                n.value = value;
                return;
            }
        table[hash] = new Node(key, value, table[hash]);
    }

    public V get(K key) {
        int hash = key.hashCode() % M;
        for(Node n = table[hash]; n != null; n = n.next)
            if(key.equals(n.key))
                return (V)n.value;
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode() % M;
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        Node(Object k, Object v) {
            this(k,v,null);
        }

        Node(Object k, Object v, Node n) {
            this.key   = k;
            this.value = v;
            this.next  = n;
        }
    }
}