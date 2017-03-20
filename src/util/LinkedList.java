package com.github.ancabanca.interviewprep.util;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {

    }

    public LinkedList(T data) {
        if(data == null)
            throw new NullPointerException("Data cannot be null.");
        head = new Node(data);
        tail = head;
        size++;
    }

    // getters
    public int size() {
        return size;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    // add / remove elements
    public void add(T data) {
        if(data == null)
            throw new NullPointerException("Data cannot be null.");
        Node n = new Node(data);
        if(size == 0) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            tail = tail.next;
        }
        size++;
    }

    // Removes the first apparition of data in list.
    // This method doesn't assume that data is unique in the list.
    // Returns null if data is not found in list.
    public T remove(T data) {
        if(data == null)
            throw new NullPointerException("Data cannot be null.");
        if(size == 0)
            return null; 
        if(head.data.equals(data)){
            T found = head.data;
            head = null;
            tail = null;
            return found;
        }
        return null;
    }

    // Removes the first element of the list and returns it.
    public T removeFirst() {
        if(size == 0)
            throw new NoSuchElementException("Cannot remove from empty list.");
        if(size == 1)
            tail = null;
        T found = head.data;
        head = head.next;
        size--;
        return found;
    }

    public boolean removeDuplicates() {
        boolean hasDuplicates = false;
        Node n    = head;
        Node prev = null;
        Set<T> set = new HashSet<T>();
        while(n != null) {
            if(set.contains(n.data)){
                prev.next = n.next;
                hasDuplicates = true;
            }
            else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
        return hasDuplicates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(size == 0)
            return sb.toString();
        else
            sb.append(head.data.toString());
        Node n = head;
        while(n.next != null) {
            n = n.next;
            sb.append(" " + n.data.toString());
        }
        return sb.toString();
    }

    class Node {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }
}