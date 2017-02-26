package com.github.ancabanca.interviewprep.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic stack implemented with an underlying resizing array.
 * Time complexity: O(1) amortized, O(n) worst case when resizing
 * Space complexity: O(N)
 * 
 * Better time/space complexity than the linked list implementation.
 * However, you may not want to resize your array when your planes are landing,
 * so having a constant worst time is important :)
 */
public class ArrayStack<T> implements Stack<T>, Iterable<T> {
    private T[] array;
    private int N = 0;

    @SuppressWarnings("unchecked") // the ugly cast warning
    public ArrayStack() {
        // Generic array creation is not allowed in Java
        // array = new T[1];
        array = (T[]) new Object[1]; // the ugly cast
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T s) {
        if(N == array.length)
            resizeArray(array.length * 2); // repeated doubling
        array[N++] = s;
    }

    public T pop() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot pop from an empty stack.");
        }
        T result = array[--N];
        array[N] = null; // avoid loitering
        
        if(N == array.length/4)
            resizeArray(array.length/2);

        return result;
    }

    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ArrayStack]: ");
        for (T element : this)
            sb.append(element.toString() + " ");
        return new String(sb);
    }

    @SuppressWarnings("unchecked") // the ugly cast warning
    private void resizeArray(int capacity) {
        T[] newArray = (T[])new Object[capacity];
        for(int i=0; i<N; i++)
            newArray[i] = array[i];
        array = newArray;
    }

    private class ArrayStackIterator implements Iterator<T> {
        private int current = 0;

        public boolean hasNext() {
            return current < N; 
        }

        public T next() {
            if(hasNext())
                return array[current++];
            else
                throw new NoSuchElementException();
        }

    }
}