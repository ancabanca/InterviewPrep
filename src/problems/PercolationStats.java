import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    
    private int t;
    private double[] results;
    
    // perform t independent experiments on an n-by-n grid
    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0)
            throw new IllegalArgumentException();
        this.t = t;
        results = new double[t];
        // Perform t experiments
        for (int i = 0; i < t; i++) {
            // Create a new grid and have each site initially blocked
            Percolation p = new Percolation(n);
            double openSites = 0;
            // open a site until the grid percolates
            while (!p.percolates()) {
                int x = StdRandom.uniform(1, n+1), y = StdRandom.uniform(1, n+1);
                if (!p.isOpen(x, y)) {
                    p.open(x, y);
                    openSites++;
                }
            }
            // remember how many sites were open when the system percolates
            results[i] = openSites/(n*n);
        }
    }
    
    // sample mean of percolation threshold
    public double mean() {
        double sum = 0;
        for (int i = 0; i < t; i++)
            sum += results[i];
        return sum / t;
        //return StdStats.mean(results); 
    }
    
    // sample standard deviation of percolation threshold
    public double stddev() {
        double sumOfSquares = 0;
        double mean = mean();
        for (int i = 0; i < t; i++)
            sumOfSquares += Math.pow(results[i]-mean, 2);
        return Math.sqrt(sumOfSquares / (t-1));
        //return StdStats.stddev(results);
    }
    
    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }
    
    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(t);    
    }

    // test client (described below)
    public static void main(String[] args) {
        System.out.println(String.format("Running %s experiments...", args[1]));
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}

