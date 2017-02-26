package com.github.ancabanca.interviewprep.problems;

import com.github.ancabanca.interviewprep.util.UnionFind;

import java.util.Arrays;

/**
 *  Union Find data structure with operation find(i), which returns
 *  the greatest element in i's connected component.
 */ 
public class UnionFindCanonicalElement extends UnionFind {
    private int[] max;

    public UnionFindCanonicalElement(int N) {
        super(N);
        max = new int[N];
        for(int i = 0; i < max.length; i++)
            max[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if(rootp == rootq)
            return;
        if(size[rootp] < size[rootq]) {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];    
            max[rootq] = Math.max(max[rootp], max[rootq]);
        }
        else {
            parent[rootq] = rootp;
            size[rootp] += rootq;
            max[rootp] = Math.max(max[rootp], max[rootq]);
        }
    }

    public int find(int i) {
        return max[root(i)];
    }
}