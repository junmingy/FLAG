/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/9/8
 * @Site: github.com/phdsky
 * @Description: NULL
 ******************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF WQUF; // Mantain structure
    private int edgeSize; // Percolation map edge size
    private int openSites; // Current opened sites num
    private int virtualHead;
    private int virtualTail;
    private boolean []nodeMap;

    /**
     * @brief Create n-by-n grid, with all sites blocked
     * @param n
     */
    public Percolation(int n) {
        if(n <= 0) {
            throw new java.lang.IllegalArgumentException("Input Argument n <= 0!");
        }

        edgeSize = n;
        openSites = 0; // Except 2 virtual nodes
        virtualHead = 0;
        int nodeSum  = n * n + 2; // 0 & n*n+1 represent virtual node
        virtualTail = nodeSum - 1;
        WQUF = new WeightedQuickUnionUF(nodeSum);

        nodeMap = new boolean[nodeSum];
        // virtual node is always open
        for(int i = 0; i < nodeSum; i++) {
            if(i == virtualHead || i == virtualTail)
                nodeMap[i] = true;
            else
                nodeMap[i] = false;
        }
    }

    /**
     * @brief Validate row & col range
     * @param row
     * @param col
     */
    private void validate(int row, int col) {
        if(row <= 0 || row > edgeSize) {
            throw new java.lang.IllegalArgumentException(
                    "index " + row + " is not between 1 and " + edgeSize);
        }
        if(col <= 0 || col > edgeSize) {
            throw new java.lang.IllegalArgumentException(
                    "index " + col + " is not between 1 and " + edgeSize);
        }
    }

    /**
     * @brief Open site (row, col) if it is not open already
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        validate(row, col);

        // Return it's already opened; If not, open
        if(isOpen(row, col)) return;
        int id = edgeSize * (row - 1) + col;
        nodeMap[id] = true;
        openSites++;

        // Check this node's neighbours opened or not; if opened, union
        // Up neighbour
        if(row == 1) {
            WQUF.union(id, virtualHead);
        }
        else {
            int upId = edgeSize * (row - 1 - 1) + col;
            if(nodeMap[upId] == true)
                WQUF.union(id, upId);
        }

        // Right neighbour
        if(col != edgeSize) {
            int rightId = id + 1;
            if(nodeMap[rightId] == true)
                WQUF.union(id, rightId);
        }

        // Down neighbour
        if(row == edgeSize) {
            WQUF.union(id, virtualTail);
        }
        else {
            int downId = edgeSize * row + col;
            if(nodeMap[downId] == true)
                WQUF.union(id, downId);
        }

        // Left neighbour
        if(col != 1) {
            int leftId = id - 1;
            if(nodeMap[leftId] == true)
                WQUF.union(id, leftId);
        }
    }

    /**
     * @brief is site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        validate(row, col);

        int id = edgeSize * (row - 1) + col;
        return nodeMap[id];
    }

    /**
     * @brief is site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        // backwash problem appears - bugs contained
        // http://coursera.cs.princeton.edu/algs4/checklists/percolation.html
        // https://drkbl.com/quote-avoid-backwash-in-percolation/

        validate(row, col);

        int id = edgeSize * (row - 1) + col;
        return isOpen(row, col) && WQUF.connected(id, virtualHead);
    }

    /**
     * @brief number of open sites
     * @return
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * @brief does the system percolate?
     * @return
     */
    public boolean percolates() {
        return WQUF.connected(virtualHead, virtualTail);
    }

    /**
     * @brief test client (optional)
     * @param args
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Percolation percolation = new Percolation(N);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(percolation.WQUF.connected(p, q)) continue;

            percolation.WQUF.union(p, q);

            StdOut.println(p + " " + q);
        }

        StdOut.println(percolation.WQUF.count() + "components");
        StdOut.println(percolation.isFull(18, 1));
    }
}
