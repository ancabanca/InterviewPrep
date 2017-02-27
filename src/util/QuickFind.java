package com.github.ancabanca.interviewprep.util;

/**
 * QuickFind implementation of the union-find data structure.
 * - find is O(1)
 * - union is O(n)
 */
public class QuickFind {
    private int[] array;

    public QuickFind(int n) {
        array = new int[n];
        for(int i = 0; i < array.length; i++)
            array[i] = i;
    }

    public boolean connected(int p, int q) {
        return array[p] == array[q];
    }

    public void union(int p, int q) {
        if(connected(p, q))
            return;
        int idp = array[p];
        for(int i = 0; i < array.length; i++)
            if(array[i] == idp)
                array[i] = array[q];
    }
}