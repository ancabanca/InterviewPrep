package com.github.ancabanca.interviewprep.util;

public class MaxPQ<K extends Comparable<K>> {
	private Comparable[] array;
    private static final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private int N;

    public MaxPQ() {
        this(DEFAULT_CAPACITY);
    }

    public MaxPQ(int capacity) {
        this.capacity = capacity;
        array = (K[])new Comparable[capacity+1];   
    }

    public MaxPQ(Comparable[] a) {
        this(a.length);
        for(int i = 0; i < a.length; i++)
            array[i+1] = a[i];
        for(int i = N/2; i >= 0; i++) {
            sink(i);
        }
    }

    public void insert(Comparable key) {
        if(N == capacity)
            resizeArray(2);
        array[++N] = key;
        swim(N);
    }

    public Comparable delMax() {
        Comparable max = max();
        array[1] = array[N--];
        array[N+1] = null; // avoid loitering
        sink(1);
        if(capacity > 16 && N <= capacity/4)
            resizeArray(1/2);
        return max;
    }

    public Comparable max() {
        if(N == 0)
            throw new IllegalStateException("Cannot get max from an empty MaxPQ.");
        return array[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void swim(int k) {
        while(k/2 > 0 && less(k/2, k)) {
            exchange(k,k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        int j = 2*k;
        while(j <= N) {
            if(j+1 <= N && less(j, j+1))
                j += 1;
            if(less(k, j))
                exchange(k, j);
            k = j;
            j = 2*j;
        }
    }

    private boolean less(int i, int j) {
        return array[i].compareTo(array[j]) < 0;
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