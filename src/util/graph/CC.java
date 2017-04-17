package com.github.ancabanca.interviewprep.util.graph;

public class CC {
    private final Graph G;
    private int[] cc;
    private int count;

    public CC(Graph G) {
        this.G = G;
        cc = new int[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(cc[v] == 0) {
                count++;
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        cc[v] = count;
        for(int w : G.adjacent(v))
            if(cc[w] == 0)
                dfs(w);
    }

    public int cc(int v) {
        return cc[v];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return cc[v] == cc[w];
    }
}