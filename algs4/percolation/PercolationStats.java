/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/9/8
 * @Site: github.com/phdsky
 * @Description: NULL
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private double []fractions;
    private double statsMean;
    private double statsStddev;

    /**
     * @brief perform trials independent experiments on an n-by-n grid
     * @param n
     * @param trials
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new java.lang.IllegalArgumentException("Input Argument n or trials <= 0!");
        }

        fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int randRow = StdRandom.uniform(1, n + 1); // [1, n+1)
                int randCol = StdRandom.uniform(1, n + 1); // [1, n+1)
                percolation.open(randRow, randCol); // Random row & col
            }

            fractions[i] = ((double) percolation.numberOfOpenSites() / (double)(n * n));
        }

        statsMean = StdStats.mean(fractions);
        statsStddev = StdStats.stddev(fractions);
    }

    /**
     * @brief sample mean of percolation threshold
     * @return
     */
    public double mean() {
        return statsMean;
    }

    /**
     * @brief sample standard deviation of percolation threshold
     * @return
     */
    public double stddev() {
        return statsStddev;
    }

    /**
     * @brief low endpoint of 95% confidence interval
     * @return
     */
    public double confidenceLo() {
        return (statsMean - 1.96 * statsStddev / Math.sqrt(fractions.length));
    }

    /**
     * @brief high endpoint of 95% confidence interval
     * @return
     */
    public double confidenceHi() {
        return (statsMean + 1.96 * statsStddev / Math.sqrt(fractions.length));
    }

    /**
     * @brief test client (described below)
     * @param args
     */
    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(200, 100);
        StdOut.println(percolationStats.mean());
        StdOut.println(percolationStats.stddev());
        StdOut.println(percolationStats.confidenceLo());
        StdOut.println(percolationStats.confidenceHi());
    }
}
