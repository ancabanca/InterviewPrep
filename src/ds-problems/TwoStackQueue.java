import java.util.ArrayList;
import java.util.List;

/**
 * Queue implemented with two stacks, so that each queue operation
 * takes a constant amortized number of stack operations.
 * NOTE: Java arrays are covariant but Java generics are not: that is,
 * 𝚂𝚝𝚛𝚒𝚗𝚐[] is a subtype of 𝙾𝚋𝚓𝚎𝚌𝚝[], but 𝚂𝚝𝚊𝚌𝚔<𝚂𝚝𝚛𝚒𝚗𝚐> is not a subtype of 𝚂𝚝𝚊𝚌𝚔<𝙾𝚋𝚓𝚎𝚌𝚝>.
 */
public class TwoStackQueue<T> {
    private ArrayStack<T> pushStack;
    private ArrayStack<T> popStack;
    
    public TwoStackQueue() {
        pushStack = new ArrayStack<T>();
        popStack  = new ArrayStack<T>();
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public void enqueue(T element) {
        pushStack.push(element);
    }

    public T dequeue() {
        if(isEmpty())
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        if(!popStack.isEmpty())
            return popStack.pop();
        else {
            while(pushStack.size() > 1) {
                popStack.push(pushStack.pop());
            }
            return pushStack.pop();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
        System.out.println(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.enqueue(4);
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}