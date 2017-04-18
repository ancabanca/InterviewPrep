package com.github.ancabanca.interviewprep.util.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DigraphDFSPaths {
    private int       s;
    private Digraph   g;
    private boolean[] visited;
    private int[]     pathTo;

    private LinkedList<Integer> topologicalSort;
    private boolean[]    visitedTopologicalSort;

    public DigraphDFSPaths(Digraph g, int s) {
        this.g  = g;
        this.s  = s;
        visited = new boolean[g.V()];
        pathTo  = new int[g.V()];
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for(int w : g.adjacent(v))
            if(!visited[w]) {
                pathTo[w] = v;
                dfs(w);
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

    public List<Integer> topologicalSort() {
        if(topologicalSort == null) {
            topologicalSort = new LinkedList<Integer>();
            visitedTopologicalSort = new boolean[g.V()];
            for(int i = 0; i < g.V(); i++)
                if(!visitedTopologicalSort[i])
                    dfsTopological(i);
        }
        return topologicalSort;
    }

    private void dfsTopological(int v) {
        visitedTopologicalSort[v] = true;
        for(int w : g.adjacent(v))
            if(!visitedTopologicalSort[w])
                dfsTopological(w);
        topologicalSort.addFirst(v);
    }
}