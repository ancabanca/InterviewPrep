import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.SuccessorWithDelete;
import org.junit.Test;

public class SuccessorWithDeleteTest {
    SuccessorWithDelete s = new SuccessorWithDelete(8);

    @Test
    public void testSuccessor() {
        assertEquals(5, s.successor(4));
    }

    @Test
    public void testDeleteOne() {
        s.delete(3);
        assertEquals(4, s.successor(2));
    }

    @Test
    public void testDeleteTwo() {
        s.delete(3);
        s.delete(4);
        assertEquals(5, s.successor(2));
    }

    @Test
    public void testDeleteFirst() {
        s.delete(0);
        assertEquals(2, s.successor(1));
    }

    @Test
    public void testSuccessorOfDeleted() {
        s.delete(4);
        assertEquals(5, s.successor(4));
    }

    @Test
    public void testSuccessorOfTwoDeleted() {
        s.delete(3);
        s.delete(4);
        assertEquals(5, s.successor(3));
    }
}