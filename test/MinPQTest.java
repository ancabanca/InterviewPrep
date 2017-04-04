import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.MinPQ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

public class MinPQTest {
    @Test
    public void testMinPQInsertMin() {
        MinPQ<Character> pq = new MinPQ<Character>();
        pq.insert('m');
        pq.insert('i');
        pq.insert('n');
        pq.insert('p');
        pq.insert('q');
        assertEquals(new Character('i'), pq.min());
    }

    @Test
    public void testMinPQInsertMoreMin() {
        MinPQ<Character> pq = new MinPQ<Character>();
        pq.insert('m');
        pq.insert('i');
        pq.insert('n');
        pq.insert('p');
        pq.insert('q');
        assertEquals(new Character('i'), pq.delMin());
        assertEquals(new Character('m'), pq.delMin());
        assertEquals(new Character('n'), pq.delMin());
        assertEquals(new Character('p'), pq.delMin());
        assertEquals(new Character('q'), pq.delMin());
    }

    @Test
    public void testMinPQFromFile() throws FileNotFoundException {
        MinPQ<Integer> pq = new MinPQ<Integer>();
        Scanner s = new Scanner(new File("test/input/randomInts500.txt"));
        while(s.hasNextLine()) {
            pq.insert(Integer.parseInt(s.nextLine().trim()));
        }
        assertEquals(new Integer(4), pq.min());
    }

    @Test(expected = IllegalStateException.class)
    public void testMinPQDelMinException() {
        MinPQ<Character> pq = new MinPQ<Character>();
        pq.delMin();
    }

    @Test(expected = IllegalStateException.class)
    public void testMinPQInsertDelMinException() {
        MinPQ<Character> pq = new MinPQ<Character>();
        pq.insert('p');
        pq.insert('q');
        pq.delMin();
        pq.delMin();
        pq.delMin();
    }

    @Test(expected = IllegalStateException.class)
    public void testMinPQInsertMinException() {
        MinPQ<Character> pq = new MinPQ<Character>();
        pq.insert('p');
        pq.insert('q');
        pq.delMin();
        pq.delMin();
        pq.min();
    }
}