package com.github.ancabanca.interviewprep.util.graph;

import java.util.LinkedList;

public class DigraphBFSPaths {
    private final Digraph g;
    private final int s; // starting node
    private boolean[] visited;
    private int[] pathTo;

    public DigraphBFSPaths(Digraph g, int s) {
        this.g = g;
        this.s = s;
        visited = new boolean[g.V()];
        pathTo  = new int[g.V()];
        bfs();
    }

    public void bfs() {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int v = q.removeFirst();
            for(int w : g.adjacent(v)) {
                if(!visited[w]) {
                    q.add(w);
                    visited[v] = true;
                    pathTo[w]  = v;
                }
            }
        }
    }

    public boolean hasPathTo(int w) {
        return visited[w];
    }

    public Iterable<Integer> shortestPathTo(int w) {
        LinkedList<Integer> ls = new LinkedList<Integer>();
        ls.add(w);
        int v = w;
        while(v != s) {
            ls.addFirst(pathTo[v]);
            v = pathTo[v];
        }
        return ls;
    }
}