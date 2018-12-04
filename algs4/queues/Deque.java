/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/11/21
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;
import java.util.ListIterator;

public class Deque<Item> implements Iterable<Item> {
    /**
     * @brief Construct an empty deque
     */
    public Deque() {}

    /**
     * @brief Is the deque empty?
     * @return
     */
    public boolean isEmpty() {return false;}

    /**
     * @brief Return the number of items on the deque
     * @return
     */
    public int size() {return -1;}

    /**
     * @brief Add the item to the front
     * @param item
     */
    public void addFirst(Item item) {}

    /**
     * @brief Add the item to the end
     * @param item
     */
    public void addLast(Item item) {}

    /**
     * @brief Remove and return the item from the front
     * @return
     */
    public Item removeFirst() {
        Item item = null;
        return item;
    }

    /**
     * @brief Remove and return the item from the end
     * @return
     */
    public Item removeLast() {
        Item item = null;
        return item;
    }

    /**
     * @brief Return an iterator over items in order from front to end
     * @return
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Item previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Item item) {

            }

            @Override
            public void add(Item item) {

            }
        };
    }


    /**
     * @brief Unit testing (optional)
     * @param args
     */
    public static void main(String[] args) {

    }
}
