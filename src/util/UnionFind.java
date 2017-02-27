package com.github.ancabanca.interviewprep.util;

/**
 * Union-find data structure implemented with the weighted quick union algorithm with path compression.
 * The weighted implementation + path compression will keep the trees at a minimum height.
 * - find and union are done in practically constant time
 */
public class UnionFind {
    protected int[] parent;
    protected int[] size;
    protected int connectedComponents;

    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        size = new int[n];
        for(int i = 0; i < size.length; i++)
            size[i] = 1;
        connectedComponents = n;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if(rootp == rootq)
            return;
        if(size[rootp] < size[rootq]) {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];    
        }
        else {
            parent[rootq] = rootp;
            size[rootp] += rootq;
        }
        connectedComponents--;
    }

    /*
     * Gets the number of connected components.
     */
    public int connectedComponents() {
        return connectedComponents;
    }

    protected int root(int p) {
        int q = p;
        while(q != parent[q]) {
            parent[q] = parent[parent[q]]; // path compression
            q = parent[q];
        }
        return q;
    }
}