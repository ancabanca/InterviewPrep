package com.github.ancabanca.interviewprep.util.graph;

import java.util.LinkedList;

public class BFSPaths {
    private final Graph G;
    private final int s; // starting node
    private boolean[] visited;
    private int[] pathTo;

    public BFSPaths(Graph G, int s) {
        this.G = G;
        this.s = s;
        bfs();
    }

    public void bfs() {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int v = q.removeFirst();
            for(int w : G.adjacent(v)) {
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