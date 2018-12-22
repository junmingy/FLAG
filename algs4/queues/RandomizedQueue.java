/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/12/15
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] rq;

    private int N;

    /**
     * @brief Construct an empty randomized queue
     */
    public RandomizedQueue() {
        rq = (Item[]) new Object[1];
        N = 0;
    }

    /**
     * @brief Is the randomized queue empty?
     * @return
     */
    public boolean isEmpty() {
        return (N == 0);
    }

    /**
     * @brief Return the number of items on the randomized queue
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * @brief Resize queue if size is not enough
     */
    private void resize(int max) {
        Item[] temp = (Item []) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = rq[i];
        }

        rq = temp;
    }

    /**
     * @brief Add the item
     * @param item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Input item is null!");
        }

        if (N == rq.length) {
            resize(2 * rq.length);
        }

        rq[N++] = item;
    }

    /**
     * @brief Remove and return a random item
     * @return
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Randomized Queue is empty!");
        }

        int pick = StdRandom.uniform(N);
        Item item = rq[pick];
        rq[pick] = rq[N - 1];
        rq[N - 1] = null;
        N--;

        if (N > 0 && N == rq.length / 4) {
            resize(rq.length / 2);
        }

        return item;
    }

    /**
     * @brief Return a random item (but do not remove it)
     * @return
     */
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Randomized Queue is empty!");
        }

        return rq[StdRandom.uniform(N)];
    }

    /**
     * @brief Return an independent iterator over items in random order
     * @return
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    /**
     * @brief
     */
    private class ArrayIterator implements Iterator<Item> {

        private Item[] iterRQ;
        private int n;

        public ArrayIterator() {
            n = N;

            iterRQ = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                iterRQ[i] = rq[i];
            }
        }

        public boolean hasNext() {
            return n > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more items to return!");
            }

            int pick = StdRandom.uniform(n);
            Item item = iterRQ[pick];

            // Swap pick & last
            iterRQ[pick] = iterRQ[n - 1];
            iterRQ[n - 1] = item;

            n--;

            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("No remove() method!");
        }
    }

    /**
     * @brief Unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();

        rq.enqueue("i");
        rq.enqueue("am");
        rq.enqueue("phd");
        StdOut.println(rq.dequeue());
        //StdOut.println(rq.dequeue());
        //StdOut.println(rq.dequeue());
        StdOut.println(rq.sample());

        StdOut.println("--------------");

        for (String s : rq) {
            StdOut.println(s);
        }
    }
}
