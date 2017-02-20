import java.util.Iterator;

/**
 * Generic stack implemented as a linked list.
 * Time complexity: O(1) for every operation
 * Space complexity: O(N)
*/
public class LinkedListStack<T> implements Stack<T>, Iterable<T> {
    private Node head = null;
    private int size;

    public boolean isEmpty() {
      return head == null;
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (isEmpty()) {
          throw new UnsupportedOperationException("Cannot pop from an empty stack.");
        }
        T result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public void push(T value) {
        Node newHead = new Node();
        newHead.value = value;
        newHead.next = head;
        head = newHead;
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(!(other instanceof LinkedListStack))
            return false;
        LinkedListStack<T> that = (LinkedListStack<T>)other;
        Iterator it1 = this.iterator();
        Iterator it2 = that.iterator();
        while(it1.hasNext() && it2.hasNext())
            if(!it1.next().equals(it2.next()))
                return false;
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (T element : this)
            s = element + " " + s;
        return "[LinkedListStack]: " + s;
    }

    private class Node {
        T value;
        Node next;
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node result = current;
            current = current.next;
            return result.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}