import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListStackTest {

    @Test
    public void test() {
        Stack<String> stack = new LinkedListStack<String>();
        Scanner scanner = new Scanner("to be or not to - be - - that - - - is");
        while (scanner.hasNext()) {
            String s = scanner.next();
            if(s.equals("-"))
                stack.pop();
            else
                stack.push(s);
        }
        Stack<String> s = new LinkedListStack<String>();
        s.push("to");
        s.push("is");
        assertEquals(s,stack);
    }
}