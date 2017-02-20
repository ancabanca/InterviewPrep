import java.util.Scanner;

/**
 * Generic queue implemented with an underlying linked list.
 * Time complexity: O(1) for enqueue, dequeue
 * Space complexity: O(N)
 */
public class LinkedListQueue<T> {
    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
      return size == 0;
    }

    public void enqueue(T s) {
        Node n = new Node();
        n.value = s;
        n.next = null;

        if(isEmpty()) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("Cannot dequeue from an empty queue.");
        }
        T result = head.value;
        head = head.next;
        size--;

        return result;
    }

    public String toString() {
        String s = "[LinkedListQueue]: ";
        Node h = head;
        while(h != null) {
            s += h.value;
            s += " ";
            h = h.next;
        }
        return s;
    }

    private class Node {
        public T value;
        public Node next;
    }

    public static void main(String[] args) {
        LinkedListQueue<String> q = new LinkedListQueue<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if(s.equals("-"))
                q.dequeue();
            else
                q.enqueue(s);
        }
        System.out.println(q);
    }
}