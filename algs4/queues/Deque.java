/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/12/15
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

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
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Input node is null!");
        }

        if (!isEmpty()) {
            Node oldHead = head;

            head = new Node();
            head.item = item;
            head.next = oldHead;
            head.prev = null;

            oldHead.prev = head;
        }
        else {
            Node node = new Node();
            node.item = item;
            head = node;
            tail = node;
        }

        size++;
    }

    /**
     * @brief Add the item to the end
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.IllegalArgumentException("Input node is null!");
        }

        if (!isEmpty()) {
            Node oldTail = tail;

            tail = new Node();
            tail.item = item;
            tail.prev = oldTail;
            tail.next = null;

            oldTail.next = tail;
        }
        else {
            Node node = new Node();
            node.item = item;
            head = node;
            tail = node;
        }

        size++;
    }

    /**
     * @brief Remove and return the item from the front
     * @return
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Dequeue is empty!");
        }

        Item item = head.item;

        if (size != 1) {
            head = head.next;
            head.prev = null;
        }
        else {
            head = null;
            tail = null;
        }

        size--;

        return item;
    }

    /**
     * @brief Remove and return the item from the end
     * @return
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Dequeue is empty!");
        }

        Item item = tail.item;

        if (size != 1) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            tail = null;
            head = null;
        }

        size--;

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

        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more items to return!");
            }

            Item item = current.item;
            current = current.next;

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
        Deque<String> dq = new Deque<String>();

        dq.addFirst("i");
        dq.addLast("am");
        dq.addFirst("phd");

        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeLast());

        StdOut.println("-------------");

        StdOut.println(dq.size());

        for (String s : dq) {
            StdOut.println(s);
        }
    }
}
