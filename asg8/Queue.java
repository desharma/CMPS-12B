//Queue.java
//creates a queue for each element

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {

    private class Node {
        Item item;
        Node next;
    }
    private Node head = null;
    private Node tail = null;

    public boolean isempty()
    {
        if (head == null)
        {
            return true;
        }
        return false;
        //throw new RuntimeException("Replace this with working code");
    }

    public void insert(Item newitem) {
        Node previous = tail;
        tail = new Node();
        tail.item = newitem;
        tail.next = null;
        if (isempty())
            head = tail;
        else
            previous.next = tail;

       // throw new RuntimeException("Replace this with working code");

    }

    public Iterator <Item> iterator() {
        return new Itor ();
    }

    class Itor implements Iterator <Item> {
        Node current = head;
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (! hasNext ()) throw new NoSuchElementException();
            Item result = current.item;
            current = current.next;
            return result;
        }
        public void remove() {
            //throw new UnsupportedOperationException();
        }
    }

}
