package com.github.ancabanca.interviewprep.util;

public class MinPQ<K extends Comparable<K>> {
	private Comparable[] array;
    private int capacity = 16;
    private int N;

    public MinPQ() {
        array = (K[])new Comparable[capacity+1];
    }

    public MinPQ(Comparable[] a) {
        //MinPQ();
        // to implement
    }

    public void insert(Comparable key) {
        if(N == capacity)
            resizeArray(2);
        array[++N] = key;
        swim(N);
    }

    public Comparable delMin() {
        Comparable min = min();
        array[1] = array[N--];
        array[N+1] = null; // avoid loitering
        sink(1);
        if(capacity > 16 && N <= capacity/4)
            resizeArray(1/2);
        return min;
    }

    public Comparable min() {
        if(N == 0)
            throw new IllegalStateException("Cannot get min from an empty MinPQ.");
        return array[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void swim(int k) {
        while(k/2 > 0 && greater(k/2, k)) {
            exchange(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        int j = 2*k;
        while(j <= N) {
            if(j+1 <= N && greater(j, j+1))
                j += 1;
            if(greater(k, j))
                exchange(k, j);
            k = j;
            j = 2*j;
        }
    }

    private boolean greater(int i, int j) {
        return array[i].compareTo(array[j]) > 0;
    }

    private void exchange(int i, int j) {
        Comparable x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    private void resizeArray(double factor) {
        int newCapacity = (int)factor*capacity;
        Comparable[] array = (K[])new Comparable[newCapacity+1];
        for(int i = 1; i <= capacity; i++) {
            array[i] = this.array[i];
        }
        this.array = array;
        capacity = newCapacity;
    }
}