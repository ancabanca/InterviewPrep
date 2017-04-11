package com.github.ancabanca.interviewprep.util;

import java.util.LinkedList;
import java.util.Stack;

public class GraphPaths {
    private int       s;
    private Graph     g;
    private boolean[] visited;
    private int[]     pathTo;

    public GraphPaths(Graph g, int s) {
        this.g  = g;
        this.s  = s;
        visited = new boolean[g.V()];
        pathTo  = new int[g.V()];
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        visited[v] = true;
        for(int w : g.adjacent(v))
            if(!visited[w]) {
                pathTo[w] = v;
                dfs(g,w);
            }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        LinkedList<Integer> ls = new LinkedList<Integer>();
        while(v != this.s) {
            ls.addFirst(v);
            v = pathTo[v];
        }
        ls.addFirst(this.s);
        return ls;
    }
}