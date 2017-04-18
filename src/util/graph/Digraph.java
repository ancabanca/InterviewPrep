package com.github.ancabanca.interviewprep.util.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Digraph {
    private List<Integer>[] adj;
    private int V;
    private int E;

    public Digraph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[])new LinkedList[V]; 
        for(int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    public Digraph(String filename) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filename));
        this.V = Integer.parseInt(s.nextLine());
        int E = Integer.parseInt(s.nextLine());
        
        while(s.hasNextLine()) {
            String[] vs = s.nextLine().split("\\s+");
            int v0 = Integer.parseInt(vs[0]);
            int v1 = Integer.parseInt(vs[1]);
            addEdge(v0, v1);
        }

        if(this.E != E)
            System.out.println("Warning: number of edges given in file is incorrect.");
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v0, int v1) {
        adj[v0].add(v1);
        this.E++;
    }

    public Iterable<Integer> adjacent(int v) {
        return adj[v];
    }
}