/*----------------------------------------------------------------
 *  Author:        Anca Burducea
 *  Written:       02/29/2016
 *  Last updated:  03/04/2016
 *
 *  Compilation:   javac Percolation.java
 *  Execution:     java Percolation
 *  
 *  Defines the Percolation class, which defines a grid of NxN sites
 *  and methods that check if that grid percolates.
 *
 *  % java Percolation
 *  
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private boolean[][] grid;
    private int openSites;
    private WeightedQuickUnionUF uf;
    
    public Percolation(int n) {
            if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        grid = new boolean[n][n];
        
        uf = new WeightedQuickUnionUF(n * n + 2);
    }
    
    public void open(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new IndexOutOfBoundsException();
        if (grid[i - 1][j - 1])
            return;
        grid[i - 1][j - 1] = true;
        openSites++;
        // connect with above site if open
        if (i != 1 && isOpen(i - 1, j))
            uf.union(getSite(i, j), getSite(i - 1, j));  // N*(i-1)+j-1, N*(i-2)+j-1);
        else  if (i == 1)  // if on first row, connect with virtual top site 
            uf.union(getSite(i, j), 0);
        // bottom row
        if (i != n && isOpen(i + 1, j))
            uf.union(getSite(i, j), getSite(i + 1, j));  // N*(i-1)+j-1, N*i+j-1);
        else if (i == n)  // if on last row, connect with virtual bottom site
            uf.union(getSite(i, j), getLastSite());
        // leftmost column
        if (j != 1 && isOpen(i, j - 1))
            uf.union(getSite(i,  j), getSite(i, j - 1));  // N*(i-1)+j-1, N*(i-1)+j-2);
        // rightmost column
        if (j != n && isOpen(i, j + 1))
            uf.union(getSite(i, j), getSite(i, j + 1));  // N*(i-1)+j-1, N*(i-1)+j);            
    }

    public int numberOfOpenSites() {
        return openSites;
    }
    
    public boolean isOpen(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new IndexOutOfBoundsException();
        return grid[i - 1][j - 1];
    }
    
    public boolean isFull(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n)
            throw new IndexOutOfBoundsException();
        return isOpen(i, j) && uf.connected(getSite(i, j), 0);
    }
    
    public boolean percolates() {
        return uf.connected(0, getLastSite());
    }

    private int getSite(int i, int j) {
        return n * (i - 1) + j;
    }
    
    private int getLastSite() {
        return n * n + 1;
    }
}
