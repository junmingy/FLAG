/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/12/15
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randQ = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randQ.enqueue(item);
        }

        for (String s : randQ) {
            if (k == 0) break;

            StdOut.println(s);
            k--;
        }
    }
}
