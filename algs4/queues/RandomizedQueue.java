/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/11/21
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * @brief Construct an empty randomized queue
     */
    public RandomizedQueue() {

    }

    /**
     * @brief Is the randomized queue empty?
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * @brief Return the number of items on the randomized queue
     * @return
     */
    public int size() {
        return -1;
    }

    /**
     * @brief Add the item
     * @param item
     */
    public void enqueue(Item item) {

    }

    /**
     * @brief Remove and return a random item
     * @return
     */
    public Item dequeue() {
        Item item = null;
        return item;
    }

    /**
     * @brief Return a random item (but do not remove it)
     * @return
     */
    public Item sample() {
        Item item = null;
        return item;
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
        public boolean hasNext() {
            return false;
        }

        public Item next() {
            return null;
        }

        public void remove() {

        }
    }

    /**
     * @brief Unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {

    }
}
