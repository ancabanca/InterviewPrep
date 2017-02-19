/**
 * Generic stack implemented as a linked list.
 * Time complexity: O(1) for every operation
 * Space complexity: O(N)
*/

import java.util.Iterator;

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