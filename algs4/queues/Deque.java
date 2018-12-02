/* *****************************************************************************
 * @Author: phd
 * @Date: 2018/11/21
 * @Site: github.com/phdsky
 * @Description: NULL
 **************************************************************************** */

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    public Deque() {}                           // construct an empty deque
    public boolean isEmpty() {return false;}                 // is the deque empty?
    public int size() {return -1;}                        // return the number of items on the deque
    public void addFirst(Item item) {}          // add the item to the front
    public void addLast(Item item) {}           // add the item to the end
    public Item removeFirst() {return Item;}               // remove and return the item from the front
    public Item removeLast() {return Item;}                 // remove and return the item from the end
    public Iterator<Item> iterator() {return; }         // return an iterator over items in order from front to end

    public static void main(String[] args) {

    }
}
