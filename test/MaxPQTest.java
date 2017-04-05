import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.MaxPQ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

public class MaxPQTest {
    @Test
    public void testMaxPQInsertMax() {
        MaxPQ<Character> pq = new MaxPQ<Character>();
        pq.insert('m');
        pq.insert('i');
        pq.insert('n');
        pq.insert('p');
        pq.insert('q');
        assertEquals(new Character('q'), pq.max());
    }

    @Test
    public void testMaxPQInsertMoreMax() {
        MaxPQ<Character> pq = new MaxPQ<Character>();
        pq.insert('m');
        pq.insert('i');
        pq.insert('n');
        pq.insert('p');
        pq.insert('q');
        assertEquals(new Character('q'), pq.delMax());
        assertEquals(new Character('p'), pq.delMax());
        assertEquals(new Character('n'), pq.delMax());
        assertEquals(new Character('m'), pq.delMax());
        assertEquals(new Character('i'), pq.delMax());
    }

    @Test
    public void testMaxPQFromFile() throws FileNotFoundException {
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        Scanner s = new Scanner(new File("test/input/randomInts500.txt"));
        while(s.hasNextLine()) {
            pq.insert(Integer.parseInt(s.nextLine().trim()));
        }
        assertEquals(new Integer(4987), pq.max());
    }

    @Test(expected = IllegalStateException.class)
    public void testMaxPQDelMaxException() {
        MaxPQ<Character> pq = new MaxPQ<Character>();
        pq.delMax();
    }

    @Test(expected = IllegalStateException.class)
    public void testMaxPQInsertDelMaxException() {
        MaxPQ<Character> pq = new MaxPQ<Character>();
        pq.insert('p');
        pq.insert('q');
        pq.delMax();
        pq.delMax();
        pq.delMax();
    }

    @Test(expected = IllegalStateException.class)
    public void testMaxPQInsertMaxException() {
        MaxPQ<Character> pq = new MaxPQ<Character>();
        pq.insert('p');
        pq.insert('q');
        pq.delMax();
        pq.delMax();
        pq.max();
    }
}