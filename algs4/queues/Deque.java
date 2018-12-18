/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/12/15
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node head; //head node
    private Node tail; //tail node
    private int size;

    private class Node {
        Item item; // node value
        Node next; // next node
        Node prev; // prev node
    }

    /**
     * @brief Construct an empty deque
     */
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @brief Is the deque empty?
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * @brief Return the number of items on the deque
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * @brief Add the item to the front
     * @param item
     */
    public void addFirst(Item item) {
        
    }

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
        return new ListIterator();
    }

    /**
     * @brief
     */
    private class ListIterator implements Iterator<Item> {
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
